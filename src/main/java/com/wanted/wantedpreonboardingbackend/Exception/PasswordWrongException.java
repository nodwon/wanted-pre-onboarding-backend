package com.wanted.wantedpreonboardingbackend.Exception;

public class PasswordWrongException extends RuntimeException {
    public PasswordWrongException(){
        super("8자리이상이 아닙니다.");
    }

}
