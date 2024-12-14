package com.example.framework.adapter.in.controller;

import com.example.application.port.in.answer.CreateAnswerInputPort;
import com.example.application.port.in.answer.DeleteAnswerInputPort;
import com.example.framework.adapter.in.dto.in.CreateAnswerIn;
import com.example.framework.adapter.in.dto.out.CreateAnswerOut;
import com.example.framework.adapter.in.dto.out.DeleteAnswerOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qna")
@RequiredArgsConstructor
public class AnswerController {
    private final CreateAnswerInputPort createAnswerInputPort;
    private final DeleteAnswerInputPort deleteAnswerInputPort;

    /**
     * 게시글 답변 추가
     */
    @PostMapping("/questions/{questionId}/answers")
    public ResponseEntity<CreateAnswerOut> createAnswer(
            @PathVariable(value = "questionId") Long questionId,
            @RequestBody CreateAnswerIn createAnswerIn) {
        CreateAnswerOut createAnswerOut = createAnswerInputPort.createAnswer(questionId, createAnswerIn);
        return ResponseEntity.ok(createAnswerOut);
    }

    /**
     * 게시글 답변 삭제
     */
    @DeleteMapping("/answers/{answerId}")
    public ResponseEntity<DeleteAnswerOut> deleteAnswer(@PathVariable(value = "answerId") Long answerId) {
        DeleteAnswerOut deleteAnswerOut = deleteAnswerInputPort.deleteAnswer(answerId);
        return ResponseEntity.ok(deleteAnswerOut);
    }
}
