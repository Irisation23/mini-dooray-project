package com.nhnacademy.minidoorayclient.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nhnacademy.minidoorayclient.oath2.GithubProfile;
import com.nhnacademy.minidoorayclient.oath2.OAuthToken;

public interface Oauth2Service {

    GithubProfile getGithubProfile(OAuthToken oAuthToken) throws JsonProcessingException;

    OAuthToken getOAuthToken(String code) throws JsonProcessingException;
}
