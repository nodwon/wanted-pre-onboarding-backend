package com.wanted.wantedpreonboardingbackend.service;

import com.wanted.wantedpreonboardingbackend.domain.Article;
import com.wanted.wantedpreonboardingbackend.dto.ArticleCreateRequest;
import com.wanted.wantedpreonboardingbackend.dto.ArticleResponse;
import com.wanted.wantedpreonboardingbackend.dto.ArticleUpdateRequest;
import com.wanted.wantedpreonboardingbackend.repository.ArticleRepository;
import com.wanted.wantedpreonboardingbackend.repository.MemberRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class ArticlesService {

    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;

    public ArticlesService(ArticleRepository articleRepository, MemberRepository memberRepository) {
        this.articleRepository = articleRepository;
        this.memberRepository = memberRepository;
    }

    //새로운 게시글 생성
    public  Long CreateArticle(ArticleCreateRequest request){

        Article article = Article.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
        Article saveArticle = articleRepository.save(article);
        return saveArticle.getId();
    }

    // 게시글 목록
    @Transactional(readOnly = true)
    public Page<Article> AllArticle(Pageable pageable){
        return articleRepository.findAll(pageable);
    }
    // 특정 게시글 조회
    @Transactional(readOnly = true)
    public ArticleResponse articleById(Long article_Id) throws ChangeSetPersister.NotFoundException {
        Article article = articleRepository.findById(article_Id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        ArticleResponse articleResponse = new ArticleResponse(article);
        return articleResponse;
    }
    // 게시글 수정
    public Long updateArticle(ArticleUpdateRequest request) throws ChangeSetPersister.NotFoundException {
        Article article = articleRepository.findById(request.getArticle_Id()).orElseThrow(() ->new ChangeSetPersister.NotFoundException());

        article.setTitle(request.getTitle());
        article.setContent(request.getContent());

        articleRepository.save(article);
        return article.getId();

    }
    public void deleteArticle(Long member_Id, Long article_Id){
        Article article = articleRepository.getReferenceById(article_Id);
        articleRepository.deleteArticleById(article_Id, member_Id);
        articleRepository.flush();
    }





}
