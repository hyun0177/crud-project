package com.example.firstproject.api;

import com.example.firstproject.Dto.ArticleForm;
import com.example.firstproject.Entity.Article;
import com.example.firstproject.Repository.ArticleRepository;
import com.example.firstproject.service.ArticleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleApiController {
    @Autowired // 게시글 리파지터리 주입
    private ArticleService articleService;


    //GET
    @GetMapping("/api/Articles")
    public List<Article> index() {
        return articleService.index();
    }

    @GetMapping("/api/Articles/{id}")
    public Article show(@PathVariable Long id) {
        return articleService.show(id);
    }

    //POSt
    @PostMapping("/api/Articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto) {
        Article created =  articleService.create(dto);

        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    //PATCH
    @PatchMapping("/api/Articles/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody ArticleForm dto) {
        Article updated = articleService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //DELETE
    @DeleteMapping("/api/Articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id){
        Article deleted = articleService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).body(deleted):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    @PostMapping("/api/Transaction-test")
    public ResponseEntity<List<Article>> transactionTest(@RequestBody List<ArticleForm> dtos){
        List<Article> createdList = articleService.createArticles(dtos);

        return (createdList != null) ?
                ResponseEntity.status(HttpStatus.OK).body(null):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
