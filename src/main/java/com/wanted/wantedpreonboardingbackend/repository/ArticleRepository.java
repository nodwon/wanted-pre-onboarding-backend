package com.wanted.wantedpreonboardingbackend.repository;

import com.wanted.wantedpreonboardingbackend.domain.Article;
import com.wanted.wantedpreonboardingbackend.domain.QArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;

public interface ArticleRepository extends JpaRepository<Article, Long>,
        QuerydslPredicateExecutor<Article>,
        QuerydslBinderCustomizer<QArticle> {




    void deleteArticleById(Long articleId, Long member_id);
}
