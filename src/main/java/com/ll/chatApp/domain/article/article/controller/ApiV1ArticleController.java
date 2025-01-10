package com.ll.chatApp.domain.article.article.controller;

import com.ll.chatApp.domain.article.article.entity.Article;
import com.ll.chatApp.domain.article.article.servise.ArticleService;
import com.ll.chatApp.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ApiV1ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public List<Article> getArticles() {
        return articleService.findAll();
    }

    @GetMapping("/{id}")
    public Article getArticle(@PathVariable("id") Long id) {
        return articleService.findById(id).get();
    }

    @PostMapping
    public RsData writeArticle(@RequestBody Article article) {
        return articleService.write(article.getAuthor().getId(), article.getTitle(), article.getContent());
    }

    @PatchMapping("/{id}")
    public void updateArticle(@PathVariable("id") Long id, @RequestBody Article article) {
        this.articleService.modify(article, article.getTitle(),article.getContent());
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable("id") Long id) {
        this. articleService.delete(id);

    }
}
