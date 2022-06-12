package com.nhnacademy.minidoorayclient.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.minidoorayclient.oath2.GithubProfile;
import com.nhnacademy.minidoorayclient.oath2.OAuthToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource("classpath:githubOauth.properties")
public class Oauth2ServiceImpl implements Oauth2Service {
    @Value("${redirect_url}")
    private String redirectURL;
    @Value("${token_request_url}")
    private String tokenRequestUrl;
    @Value("${profile_request_url}")
    private String profileRequestUrl;
    @Value("${client.id}")
    private String clientId;
    @Value("${client.secret}")
    private String clientSecret;

    @Override
    public GithubProfile getGithubProfile(OAuthToken oAuthToken) throws JsonProcessingException {
        RestTemplate profileRequestTemplate = new RestTemplate();
        ResponseEntity<String> profileResponse = profileRequestTemplate.exchange(
            profileRequestUrl,
            HttpMethod.GET,
            getProfileRequestEntity(oAuthToken),
            String.class
        );

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(profileResponse.getBody(), GithubProfile.class);
    }

    private HttpEntity<MultiValueMap<String, String>> getProfileRequestEntity(OAuthToken oAuthToken) {
        HttpHeaders infoRequestHeaders = new HttpHeaders();
        infoRequestHeaders.add("Authorization", "token " + oAuthToken.getAccessToken());
        return new HttpEntity<>(infoRequestHeaders);
    }

    @Override
    public OAuthToken getOAuthToken(String code) throws JsonProcessingException {
        HttpEntity<MultiValueMap<String, String>> codeRequestHttpEntity = getCodeRequestHttpEntity(code);
        RestTemplate tokenRequestTemplate = new RestTemplate();
        ResponseEntity<String> response = tokenRequestTemplate.exchange(tokenRequestUrl,
            HttpMethod.POST,
            getCodeRequestHttpEntity(code),
            String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        OAuthToken oAuthToken = null;
        return objectMapper.readValue(response.getBody(), OAuthToken.class);
    }

    private HttpEntity<MultiValueMap<String, String>> getCodeRequestHttpEntity(String code) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("code", code);
        params.add("redirect_url", redirectURL);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        return new HttpEntity<>(params, headers);
    }
}
