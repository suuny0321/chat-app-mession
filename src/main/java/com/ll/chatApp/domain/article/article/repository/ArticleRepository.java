package com.ll.chatApp.domain.article.article.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Article extends JpaRepository<Article,Long> {
}
