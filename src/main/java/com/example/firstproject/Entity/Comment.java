package com.example.firstproject.Entity;

import com.example.firstproject.Dto.CommentDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Comment {
    @Id // 대표키 지정
    @GeneratedValue(strategy= GenerationType.IDENTITY) // DB가 자동으로 1씩 추가
    private Long id;
    @ManyToOne // Comment엔티티와 Article엔티티를 다대일 관계로 설정
    @JoinColumn(name="article_id")
    private Article article;
    @Column
    private String nickname;
    @Column
    private String body;


    public static Comment createComment(CommentDto dto, Article article){
        //예외 발생
        if (dto.getId() != null)
            throw new IllegalArgumentException("댓글 생성 실패! 댓글의 id가 없어야 합니다.");
        if (!Objects.equals(dto.getArticleId(), article.getId()))
            throw new IllegalArgumentException("댓글 생성 실패! 게시글의 id가 잘못됐습니다.");

        //엔티티 생성 반환
        return new Comment(
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody()
        );
    }

    public void patch(CommentDto dto) {
        if (!Objects.equals(this.id, dto.getId()))
            throw new IllegalArgumentException("댓글 수정 실패! 잘못된 id가 입력됐습니다!");

        if (dto.getNickname() != null)
            this.nickname = dto.getNickname();
        if (dto.getBody() != null)
            this.body = dto.getBody();
    }
}
