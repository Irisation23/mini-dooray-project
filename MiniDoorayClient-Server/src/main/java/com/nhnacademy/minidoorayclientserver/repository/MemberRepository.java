package com.nhnacademy.minidoorayclientserver.repository;

import com.nhnacademy.minidoorayclientserver.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
