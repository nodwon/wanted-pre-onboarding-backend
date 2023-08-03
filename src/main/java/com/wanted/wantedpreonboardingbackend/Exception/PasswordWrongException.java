package com.wanted.wantedpreonboardingbackend.Exception;

public class PasswordWrongException extends RuntimeException {
    public PasswordWrongException(){
        super("Password is Wrong");
    }

}
