package com.wanted.wantedpreonboardingbackend.Exception;

public class EmailExistedException extends RuntimeException {
    public EmailExistedException(String email) {
        super("Email is Wrong");
    }
}
