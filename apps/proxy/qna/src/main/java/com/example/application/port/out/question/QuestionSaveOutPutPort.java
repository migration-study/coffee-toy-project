package com.example.application.port.out.question;

import com.example.domain.entity.QuestionRefactoring;


public interface QuestionSaveOutPutPort {
    /**
     * ToDO
     * - selectQuestionMaxId 메서드에 대하여 다른 인터페이스로 추출(QuestionQueryOutPutPort)
     */
    Long selectQuestionMaxId();
    void saveQuestion(QuestionRefactoring question);
}
