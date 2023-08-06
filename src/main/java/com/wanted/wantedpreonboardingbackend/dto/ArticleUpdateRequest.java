package com.wanted.wantedpreonboardingbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class ArticleUpdateRequest {

    @NotNull
    private Long article_Id;

    @NotNull
    private String title;

    @NotNull
    private String content;
}
