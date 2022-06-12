package com.nhnacademy.minidoorayclientserver.exception;

public class NotFindMemberByEmailException extends IllegalArgumentException{
    public NotFindMemberByEmailException(String s) {
        super(s);
    }
}
