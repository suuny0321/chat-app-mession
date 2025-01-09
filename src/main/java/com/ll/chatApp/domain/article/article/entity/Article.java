package com.ll.chatApp.domain.article.article.entity;


import com.ll.chatApp.domain.article.article.articleTag.entity.ArticleTag;
import com.ll.chatApp.domain.article.articleComment.entity.ArticleComment;
import com.ll.chatApp.domain.member.member.entity.Member;
import com.ll.chatApp.global.jpa.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Article extends BaseEntity {

    private String title;
    private String content;

    @ManyToOne
    private Member author;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true) // fetch = FetchType.LAZY
    @Builder.Default
    @ToString.Exclude
    private List<ArticleComment> comments = new ArrayList<>();

    public void addComment(Member memberAuthor, String commentBody) {
        ArticleComment comment = ArticleComment.builder()
                .article(this)
                .author(memberAuthor)
                .body(commentBody)
                .build();

        comments.add(comment);
    }

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude
    private List<ArticleTag> tags = new ArrayList<>();

    public void addTag(String tagContent) {
        ArticleTag tag = ArticleTag.builder()
                .article(this)
                .content(tagContent)
                .build();
        tags.add(tag);
    }

    public void addTag(String... tagContents) {
        for (String tagContent : tagContents) {
            addTag(tagContent);
        }
    }
}