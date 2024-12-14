INSERT INTO question (id, writer_id, title, contents, created_at, deleted) VALUES (1, 1, '게시글 제목1', '게시글 내용1', CURRENT_TIMESTAMP(), false);
INSERT INTO question (id, writer_id, title, contents, created_at, deleted) VALUES (2, 2, '게시글 제목2', '게시글 내용2', CURRENT_TIMESTAMP(), false);

INSERT INTO answer (writer_id, contents, created_at, question_id, deleted) VALUES (1, '게시글 답변1', CURRENT_TIMESTAMP(), 1, false);
INSERT INTO answer (writer_id, contents, created_at, question_id, deleted) VALUES (2, '게시글 답변2', CURRENT_TIMESTAMP(), 1, false);