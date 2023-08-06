package com.wanted.wantedpreonboardingbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCreateRequest {

    private String title;
    private String content;
}
