package com.ll.chatApp.domain.article.article.servise;

import com.ll.chatApp.domain.article.article.entity.Article;
import com.ll.chatApp.domain.article.article.repository.ArticleRepository;
import com.ll.chatApp.domain.member.member.entity.Member;
import com.ll.chatApp.global.rsData.RsData;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional
    public Article  write(String title, String content) {
        Article article = Article.builder()
                .author(Member.builder().id(1L).build())
                .title(title)
                .content(content)
                .build();

        return articleRepository.save(article);
    }

    public Optional<Article> findById(Long id) {
        return articleRepository.findById(id);
    }

    @Transactional
    public void modify(Article article, String title, String content) {
        article.setTitle(title);
        article.setContent(content);
    }


    public List<Article> findAll() {
        return articleRepository.findAll();
    }


    public void delete(Long id) {
        this.articleRepository.deleteById(id);
    }
}
