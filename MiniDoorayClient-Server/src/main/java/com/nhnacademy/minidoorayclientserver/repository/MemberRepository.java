package com.nhnacademy.minidoorayclientserver.repository;

import com.nhnacademy.minidoorayclientserver.dto.response.MemberResponseDto;
import com.nhnacademy.minidoorayclientserver.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {

    MemberResponseDto findByMemberNo(Long memberNo);

    Optional<Member> findByMemberEmail(String email);

    Optional<Member> findByMemberId(String memberId);

    List<Member> findAll();

    Optional<Member> getByMemberNo(Long memberNo);
}
