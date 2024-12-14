package com.example.framework.adapter.in.controller;

import com.example.application.port.in.CreateInputPort;
import com.example.application.port.in.DeleteInputPort;
import com.example.application.port.in.ModifyInputPort;
import com.example.framework.adapter.in.dto.in.CreateAnswerIn;
import com.example.framework.adapter.in.dto.in.CreateQuestionIn;
import com.example.framework.adapter.in.dto.out.CreateAnswerOut;
import com.example.framework.adapter.in.dto.out.CreateQuestionOut;
import com.example.framework.adapter.in.dto.out.DeleteAnswerOut;
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
public class QnAController {
    private final CreateInputPort createInputPort;
    private final ModifyInputPort modifyInputPort;
    private final DeleteInputPort deleteInputPort;

    /**
     * 게시글 추가
     */
    @PostMapping("/questions")
    public ResponseEntity<CreateQuestionOut> createQuestion(
            @RequestBody CreateQuestionIn createQuestionIn) {
        CreateQuestionOut createQuestionOut = createInputPort.createQuestion(createQuestionIn);
        System.out.println("게시글 추가 응답 : " + createQuestionOut);
        return ResponseEntity.ok(createQuestionOut);
    }

    /**
     * 게시글 삭제
     */
    @DeleteMapping("/questions/{questionId}")
    public ResponseEntity<DeleteQuestionOut> deleteQuestion(
            @PathVariable(value = "questionId") Long questionId) {
        DeleteQuestionOut deleteQuestionOut = deleteInputPort.deleteQuestion(questionId);
        System.out.println("게시글 삭제 응답 : " + deleteQuestionOut);
        return ResponseEntity.ok(deleteQuestionOut);
    }

    /**
     * 게시글 답변 추가
     */
    @PostMapping("/questions/{questionId}/answers")
    public ResponseEntity<CreateAnswerOut> createAnswer(
            @PathVariable(value = "questionId") Long questionId,
            @RequestBody CreateAnswerIn createAnswerIn) {
        CreateAnswerOut createAnswerOut = createInputPort.createAnswer(questionId, createAnswerIn);
        return ResponseEntity.ok(createAnswerOut);
    }

    /**
     * 게시글 답변 삭제
     */
    @DeleteMapping("/answers/{answerId}")
    public ResponseEntity<DeleteAnswerOut> deleteAnswer(@PathVariable(value = "answerId") Long answerId) {
        DeleteAnswerOut deleteAnswerOut = deleteInputPort.deleteAnswer(answerId);
        return ResponseEntity.ok(deleteAnswerOut);
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