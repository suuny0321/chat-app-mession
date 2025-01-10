package com.ll.chatApp.domain.article.article.controller;

import com.ll.chatApp.domain.article.article.dto.ArticleDto;
import com.ll.chatApp.domain.article.article.dto.ArticleWriteRequest;
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
    public List<ArticleDto> getArticles() {
        List<Article> articles = articleService.findAll();
        List<ArticleDto> articeDtoList = articles.stream()
                .map(ArticleDto::new)
                .toList();

        return articeDtoList;
    }

    @GetMapping("/{id}")
    private ArticleDto getArticle(@PathVariable("id") Long id) {
        Article article = articleService.findById(id).orElseGet(Article::new);
        return new ArticleDto(article);
    }

    @PostMapping
    public RsData<ArticleDto> writeArticle(@RequestBody ArticleWriteRequest articleWriteRequest) {
        Article article = articleService.write(articleWriteRequest.getTitle(), articleWriteRequest.getContent());
        return new RsData<>(
                "200",
                "게시글이 작성에 성공하였습니다.",
                new ArticleDto(article)
        );
    }

    @PatchMapping("/{id}")
    public void updateArticle(@PathVariable("id") Long id, @RequestBody Article article) {
        this.articleService.modify(article, article.getTitle(), article.getContent());
    }

    @DeleteMapping("/{id}")
    public RsData<Void> deleteArticle(@PathVariable("id") Long id) {
        this.articleService.delete(id);
        return new RsData<>(
                "200",
                "게시글이 삭제에 성공하였습니다."
        );

    }
}
