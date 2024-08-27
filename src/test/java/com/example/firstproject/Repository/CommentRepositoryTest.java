package com.example.firstproject.Repository;

import com.example.firstproject.Entity.Article;
import com.example.firstproject.Entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;
    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        //1
        Long articleId = 4L;
        //2
        List<Comment> comments = commentRepository.findByArticleId(articleId);
        //3

        Article article = new Article(4L, "노래", "댓글1");
        Comment a = new Comment(1L, article, "Kim", "사랑 안해");
        Comment b = new Comment(2L, article, "Park", "qwer");
        Comment c = new Comment(3L, article, "Kim", "사랑 안해");
        List<Comment> expected = Arrays.asList(a, b, c);

        //4
        assertEquals(expected.toString(), comments.toString(), "4번 글의 모든 댓글 출력");
    }
}