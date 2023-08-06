package com.wanted.wantedpreonboardingbackend.controller;

import com.wanted.wantedpreonboardingbackend.domain.Article;
import com.wanted.wantedpreonboardingbackend.dto.ArticleCreateRequest;
import com.wanted.wantedpreonboardingbackend.dto.ArticleResponse;
import com.wanted.wantedpreonboardingbackend.service.ArticlesService;
import com.wanted.wantedpreonboardingbackend.service.PaginationService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
@Controller
public class ArticleController {

    private final ArticlesService articlesService;

    private final PaginationService paginationService;

    //게시글 생성
    @PostMapping
    public ResponseEntity<Long> createArticles(@RequestBody ArticleCreateRequest request){
        Long result = articlesService.CreateArticle(request);

        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(result);
    }
    //게시글 목록 조회


    //특정게시글 조회
    @GetMapping("/{article_id}")
    public ArticleResponse Articledetail(@PathVariable Long article_id) throws ChangeSetPersister.NotFoundException {
        ArticleResponse response = articlesService.articleById(article_id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response).getBody();
    }
    // 특정 게시글 수정


    // 특정 게시글 삭제
    @PostMapping("/{article_id}/delete")
    public String delteArticle(@PathVariable Long article_Id, @PathVariable Long member_Id){
        articlesService.deleteArticle(article_Id, member_Id);

        return "redirect:/articles";
    }
}
