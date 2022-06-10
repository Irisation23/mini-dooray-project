package com.nhnacademy.minidoorayclientserver.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "member")
public class Member {

    @Id
    @Column(name = "member_number")
    @GeneratedValue(strategy = IDENTITY)
    private Long memberNo;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "member_password")
    private String memberPassword;

    @Column(name = "member_email")
    private String memberEmail;

    @Column(name = "member_status")
    private String memberStatus;

    public Member(String memberId, String memberPassword, String memberEmail, String memberStatus) {
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        this.memberEmail = memberEmail;
        this.memberStatus = memberStatus;
    }
}
