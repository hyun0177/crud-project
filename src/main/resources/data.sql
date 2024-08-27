INSERT INTO article(title, content) VALUES('가가가가', '1111');
INSERT INTO article(title, content) VALUES('나나나나', '2222');
INSERT INTO article(title, content) VALUES('다다다다', '3333');

INSERT INTO article(title, content) VALUES('노래', '댓글1');
INSERT INTO article(title, content) VALUES('영화', '댓글2');
INSERT INTO article(title, content) VALUES('드라마', '댓글3');

INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Kim', '사랑 안해');
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Park', 'qwer');
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Kim', '사랑 안해');

INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Park', '우생순');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Kim', '쓰나미');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Park', '마라톤');

INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Park', '헬로마마');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Kim', '불시착');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Park', '악마판사');