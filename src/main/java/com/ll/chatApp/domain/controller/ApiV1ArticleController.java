package com.ll.chatApp.domain.controller;

import com.ll.chatApp.domain.article.article.servise.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ApiV1ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public void getArticles() {

    }

    @GetMapping("/{id}")
    public void getArticle(@PathVariable("id") Long id) {

    }

    @PostMapping
    public void writeArticle() {

    }

    @PatchMapping("{id}")
    public void updateArticle(@PathVariable("id")Long id){

    }

    @DeleteMapping("{id}")
    public void deleteArticle(@PathVariable("id") Long id){

    }
}
