package com.wanted.wantedpreonboardingbackend.dto;

import com.wanted.wantedpreonboardingbackend.domain.Article;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ArticleResponse{
    Long id;
    String title;
    String content;

    public ArticleResponse(Article article){
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();

    }
}

