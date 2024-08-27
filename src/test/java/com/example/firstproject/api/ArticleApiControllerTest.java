package com.example.firstproject.api;

import com.example.firstproject.Dto.ArticleForm;
import com.example.firstproject.Entity.Article;
import com.example.firstproject.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleApiControllerTest {
    @Autowired
    ArticleService articleService;
    @Test
    void index() {
        //1. 예상 데이터
        Article a = new Article(1L, "가가가가", "1111");
        Article b = new Article(2L, "나나나나", "2222");
        Article c = new Article(3L, "다다다다", "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));

        //2. 실제 데이터 획득하기
        List<Article> articles = articleService.index();

        //3. 예상 데이터와 실제 데이터 비교해 검증하기
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show_성공() {
        Long id = 1L;
        Article expected = new Article(id, "가가가가", "1111");

        Article article = articleService.show(id);

        assertEquals(expected.toString(), article.toString());

    }
    @Test
    void show_실패(){
        Long id = -1L;
        Article expected = null;

        Article article = articleService.show(id);

        assertEquals(expected, article);
    }

    @Test
    void create_ok() {
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);

        Article article = articleService.create(dto);

        assertEquals(expected.toString(), article.toString());
    }
    @Test
    void create_fail(){
        Long id = 4L;
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;

        Article article = articleService.create(dto);

        assertEquals(expected, article);
    }
}