## 게시판 도메인 모듈

### 사용자 시나리오
1. 사용자가 게시판에 질문을 생성한다.
2. 생성된 게시판 질문에 답변을 할 수 있다.
3. 로그인 사용자와 질문한 사람이 같은 경우 삭제 가능하다.
4. 질문자와 답변 글의 모든 답변자 같은 경우 삭제가 가능하다.
5. 질문자와 답변자가 다른 경우 답변을 삭제 할 수 없다.
6. 게시판에 커피 메뉴를 추가하는 문의가 있으면 메뉴 추가를 할 수 있다.
7. 게시판에 커피 금액을 변경하는 문의가 있을 경우 금액 변경이 가능하다.
8. 메뉴 추가와 금액 변경을 관리자만 가능하다.

### API 명세
- 게시글 생성
- 게시글 답변
- 게시글 삭제
- 게시글 답변 삭제
- 커피 메뉴 추가
- 커피 금액 변경