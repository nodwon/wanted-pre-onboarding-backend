package com.wanted.wantedpreonboardingbackend.dto;

public record ArticlesRequest(
        String title,
        String content
) {
    public static ArticlesRequest of(String title, String content){
        return new ArticlesRequest(title, content);
    }

}
