package com.example.service;

import com.example.CannotDeleteException;
import com.example.domain.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("qnaService")
public class QnAService {
    @Resource(name = "questionRepository")
    private QuestionRepository questionRepository;

    @Resource(name = "answerRepository")
    private AnswerRepository answerRepository;

    @Resource(name = "deleteHistoryService")
    private DeleteHistoryService deleteHistoryService;

    @Transactional
    public void deleteQuestion(NsUser loginUser, long questionId) throws CannotDeleteException {
        Question question = questionRepository.findById(questionId).orElseThrow(IllegalArgumentException::new);
        question.checkCanDelete(loginUser);

        List<DeleteHistory> deleteHistories = new ArrayList<>();
        question.updateToDelete(deleteHistories);
        deleteHistoryService.saveAll(deleteHistories);
    }
}
