package com.ll.chatApp.domain.article.article.servise;

import com.ll.chatApp.domain.article.article.entity.Article;
import com.ll.chatApp.domain.article.article.repository.ArticleRepository;
import com.ll.chatApp.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private ArticleRepository articleRepository;


    public RsData<Article> write(int i, String title, String contents) {
        Article article = Article.builder()
                .title(title)
                .content(contents)
                .build();
        articleRepository.save(article);

        return RsData.of("200", " 글 작성 성공", article);

    }
}
