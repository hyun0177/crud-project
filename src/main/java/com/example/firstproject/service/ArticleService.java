package com.example.firstproject.service;

import com.example.firstproject.Dto.ArticleForm;
import com.example.firstproject.Entity.Article;
import com.example.firstproject.Repository.ArticleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article create(ArticleForm dto) {
        Article article = dto.toEntity();
        if (article.getId() != null){
            return null;
        }
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm dto) {
        Article article = dto.toEntity(); //1. DTO -> Entity 변환
        Article target = articleRepository.findById(id).orElse(null); //2. DB에 대상 엔티티가 있는지 조회하기
        if (target == null || id != article.getId()) { //3. 잘못된 요청 처리하기
            return null;
        }
        //4. 업데이트 및 정상 응답(200)하기
        target.patch(article);
        Article updated = articleRepository.save(target);
        return updated;
    }

    public Article delete(Long id) {
        //1. 대상 찾기
        Article target = articleRepository.findById(id).orElse(null);

        //2. 대상 엔티티가 없어서 요청 자체가 잘못됐을 경우
        if(target == null){
            return null;
        }

        //3. 대상 삭제하기
        articleRepository.delete(target);
        return target;
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    @Transactional
    public List<Article> createArticles(List<ArticleForm> dtos) {
        //1. dto 묶음을 엔티티 묶음으로 변환하기
        List<Article> articleList = dtos.stream()
                .map(dto -> dto.toEntity())
                .collect(Collectors.toList());

        //2. 엔티티 묶음을 DB에 저장하기
        articleList.stream()
                .forEach(article -> articleRepository.save(article));

        //3. 강제 예외 발생시키기
        articleRepository.findById(-1L)
                .orElseThrow(() -> new IllegalArgumentException("실패 !"));

        //4. 결과 값 반환하기
        return articleList;
    }
}
