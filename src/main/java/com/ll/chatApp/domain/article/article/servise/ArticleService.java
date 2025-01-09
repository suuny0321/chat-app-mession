package com.ll.chatApp.domain.article.article.servise;


import com.ll.chatApp.domain.article.article.entity.Article;
import com.ll.chatApp.domain.article.article.repository.ArticleRepository;
import com.ll.chatApp.domain.member.member.entity.Member;
import com.ll.chatApp.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor

public class ArticleService {
    private final  ArticleRepository articleRepository;


    public RsData<Article> write(Long memberId, String title, String content) {
        Article article = Article.builder()
                .author(Member.builder().id(memberId).build())
                .title(title)
                .content(content)
                .build();

        articleRepository.save(article);

        return RsData.of("200", "%d번 게시글이 작성되었습니다.".formatted(article.getId()), article);

    }

    public Page<Article> search(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }
}
