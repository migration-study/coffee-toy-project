package com.example.framework.adapter.in.controller;

import com.example.application.port.in.question.CreateQuestionInputPort;
import com.example.application.port.in.question.DeleteQuestionInputPort;
import com.example.framework.adapter.in.dto.in.CreateQuestionIn;
import com.example.framework.adapter.in.dto.out.CreateQuestionOut;
import com.example.framework.adapter.in.dto.out.DeleteQuestionOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * QnA 컨트롤러
 */
@RestController
@RequestMapping("/qna")
@RequiredArgsConstructor
public class QuestionController {
    private final CreateQuestionInputPort createQuestionInputPort;
    private final DeleteQuestionInputPort deleteQuestionInputPort;

    /**
     * 게시글 추가
     */
    @PostMapping("/questions")
    public ResponseEntity<CreateQuestionOut> createQuestion(
            @RequestBody CreateQuestionIn createQuestionIn) {
        CreateQuestionOut createQuestionOut = createQuestionInputPort.createQuestion(createQuestionIn);
        System.out.println("게시글 추가 응답 : " + createQuestionOut);
        return ResponseEntity.ok(createQuestionOut);
    }

    /**
     * 게시글 삭제
     */
    @DeleteMapping("/questions/{questionId}")
    public ResponseEntity<DeleteQuestionOut> deleteQuestion(
            @PathVariable(value = "questionId") Long questionId) {
        DeleteQuestionOut deleteQuestionOut = deleteQuestionInputPort.deleteQuestion(questionId);
        System.out.println("게시글 삭제 응답 : " + deleteQuestionOut);
        return ResponseEntity.ok(deleteQuestionOut);
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
}