package com.example.framework.adapter.in.controller;

import com.example.application.port.in.CreateInputPort;
import com.example.application.port.in.DeleteInputPort;
import com.example.application.port.in.ModifyInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * QnA 컨트롤러
 */
@RestController
@RequestMapping("/qna")
@RequiredArgsConstructor
public class QnAController {
    private final CreateInputPort createInputPort;
    private final ModifyInputPort modifyInputPort;
    private final DeleteInputPort deleteInputPort;

    /**
     * 게시글 추가
     */
    @PostMapping("/questions")
    public void createQuestion() {

    }

    /**
     * 게시글 답변 추가
     */
    @PostMapping("/questions/{questionId}/answers")
    public void createAnswer() {

    }

    /**
     * 커피 메뉴 추가 게시글
     */
    @PostMapping("/coffees")
    public void addCoffee() {

    }

    /**
     * 커피 메뉴 가격 변경 게시글
     */
    @PostMapping("/coffees/{coffeeId}/price")
    public void modifyCoffeePrice() {

    }

    /**
     * 게시글 삭제
     */
    @DeleteMapping("/questions/{questionId}")
    public void deleteQuestion() {

    }

    /**
     * 게시글 답변 삭제
     */
    @DeleteMapping("/answers/{answerId}")
    public void deleteAnswer() {

    }
}