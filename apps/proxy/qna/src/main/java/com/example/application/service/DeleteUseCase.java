package com.example.application.service;

import com.example.application.port.in.DeleteInputPort;
import com.example.domain.NsUser;
import com.example.domain.entity.DeleteHistory;
import com.example.domain.entity.Question;
import com.example.domain.exception.CannotDeleteException;
import com.example.domain.repository.AnswerRepository;
import com.example.domain.repository.DeleteHistoryRepository;
import com.example.domain.repository.QuestionRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("deleteHistoryService")
public class DeleteUseCase implements DeleteInputPort {
    @Resource(name = "deleteHistoryRepository")
    private DeleteHistoryRepository deleteHistoryRepository;

    @Resource(name = "questionRepository")
    private QuestionRepository questionRepository;

    @Resource(name = "answerRepository")
    private AnswerRepository answerRepository;

    @Transactional
    public void deleteQuestion(NsUser loginUser, long questionId) throws CannotDeleteException {
        Question question = questionRepository.findById(questionId).orElseThrow(IllegalArgumentException::new);
        question.checkCanDelete(loginUser);

        List<DeleteHistory> deleteHistories = new ArrayList<>();
        question.updateToDelete(deleteHistories);
        saveAll(deleteHistories);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveAll(List<DeleteHistory> deleteHistories) {
        deleteHistoryRepository.saveAll(deleteHistories);
    }

    @Override
    public void deleteQuestion() {

    }

    @Override
    public void deleteAnswer() {

    }
}
