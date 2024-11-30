# 커피 주문 시스템

#### 멀티 모듈 구조
- api 모듈:
- proxy.coffee 모듈: 커피 모듈(수정)
- proxy.member 모듈: 회원 모듈(수정)
- proxy.payment 모듈: 결제 모듈(상권)
- proxy.qna 모듈: 게시판 모듈(상권)
- lib 모듈: 공통 모듈
___
#### 멀티 모듈 의존 관계
- api -> proxy.* -> lib
___
#### 브랜치 네이밍 룰
- /module-name/issue-number
___
