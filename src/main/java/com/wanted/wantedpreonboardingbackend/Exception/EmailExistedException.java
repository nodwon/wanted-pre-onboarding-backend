package com.wanted.wantedpreonboardingbackend.Exception;

public class EmailExistedException extends RuntimeException {
    public EmailExistedException(String email) {
        super("@포함되어있지 않습니다.");
    }
}
