# crud_project

springboot version - 3.1.0<br/>
java - 17<br/>
db - h2database<br/>
mustache<br/>

-------------------------------------------------------------------------------------

# APi, SERVICE

Articles(게시글)

@GET ( show ) ->  url: /api/Articles <br/>
@POST ( create )-> url: /api/Articles/{id} <br/>
@PATCH ( update )-> url: /api/Articles/{id} <br/>
@DELETE ( delete ) -> url: /api/Articles/{id} <br/>
![GET](https://github.com/user-attachments/assets/0c50b1ca-0b9a-4510-9680-2eadc53f0f41)
<br/>
Comment(댓글)<br/>
@GET(조회) -> url: /api/Articles/{articleId}/comments<br/>
@POST(생성) -> url: /api/Articles/{articleId}/comments<br/>
@PATCH(수정) -> url: /api/comments/{id}<br/>
@DELETE(삭제) -> url: /api/comments/{id}<br/>

---------------------------------------------------------------------------------------

# TABLE
<br/>
Article( Long id(primary key), String title, String content )<br/>
                
Comment( Long id(primary key, ManyToOne, JoinColume(article_id), Article article, String name, body )<br/>

-------------------------------------------------------------------------------------------



