# crud_project

springboot version - 3.1.0
java - 17
db - h2database
mustache

-------------------------------------------------------------------------------------

# APi, SERVICE

Articles(게시글)

@GET ( show ) ->  url: /api/Articles
@POST ( create )-> url: /api/Articles/{id}
@PATCH ( update )-> url: /api/Articles/{id}
@DELETE ( delete ) -> url: /api/Articles/{id}
![GET](https://github.com/user-attachments/assets/0c50b1ca-0b9a-4510-9680-2eadc53f0f41)

Comment(댓글)
@GET(조회) -> url: /api/Articles/{articleId}/comments
@POST(생성) -> url: /api/Articles/{articleId}/comments
@PATCH(수정) -> url: /api/comments/{id}
@DELETE(삭제) -> url: /api/comments/{id}

---------------------------------------------------------------------------------------

# TABLE

Article( Long id(primary key), String title, String content )
                
Comment( Long id(primary key, ManyToOne, JoinColume(article_id), Article article, String name, body )

-------------------------------------------------------------------------------------------



