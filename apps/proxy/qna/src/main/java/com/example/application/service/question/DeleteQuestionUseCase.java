package com.example.application.service.question;

import com.example.application.port.in.answer.DeleteAnswerInputPort;
import com.example.application.port.in.question.DeleteQuestionInputPort;
import com.example.application.port.out.answer.AnswerDeleteOutPutPort;
import com.example.application.port.out.answer.AnswerLoadOutPutPort;
import com.example.application.port.out.question.QuestionDeleteOutPutPort;
import com.example.application.port.out.question.QuestionLoadOutPutPort;
import com.example.domain.NsUser;
import com.example.domain.entity.AnswerRefactoring;
import com.example.domain.entity.DeleteHistory;
import com.example.domain.entity.Question;
import com.example.domain.entity.QuestionRefactoring;
import com.example.domain.exception.CannotDeleteException;
import com.example.domain.repository.AnswerRepository;
import com.example.domain.repository.DeleteHistoryRepository;
import com.example.domain.repository.QuestionRepository;
import com.example.framework.adapter.in.dto.out.DeleteAnswerOut;
import com.example.framework.adapter.in.dto.out.DeleteQuestionOut;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("deleteHistoryService")
@RequiredArgsConstructor
public class DeleteQuestionUseCase implements DeleteQuestionInputPort {
    /**
     * 기존 코드
     */
    @Resource(name = "deleteHistoryRepository")
    private DeleteHistoryRepository deleteHistoryRepository;
    @Resource(name = "questionRepository")
    private QuestionRepository questionRepository;
    @Resource(name = "answerRepository")
    private AnswerRepository answerRepository;

    private final QuestionLoadOutPutPort questionLoadOutPutPort;
    private final QuestionDeleteOutPutPort questionDeleteOutPutPort;

    /**
     * 기존 코드
     */
    @Transactional
    public void deleteQuestion(NsUser loginUser, long questionId) throws CannotDeleteException {
        Question question = questionRepository.findById(questionId).orElseThrow(IllegalArgumentException::new);
        question.checkCanDelete(loginUser);

        List<DeleteHistory> deleteHistories = new ArrayList<>();
        question.updateToDelete(deleteHistories);
        saveAll(deleteHistories);
    }

    /**
     * 기존 코드
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveAll(List<DeleteHistory> deleteHistories) {
        deleteHistoryRepository.saveAll(deleteHistories);
    }

    @Override
    @Transactional
    public DeleteQuestionOut deleteQuestion(Long questionId) {
        QuestionRefactoring question = questionLoadOutPutPort.loadQuestion(questionId);
        long loadQuestionId = question.getId();
        System.out.println("load questionId : " + loadQuestionId);

        questionDeleteOutPutPort.deleteQuestion(question);
        return DeleteQuestionOut.createSuccess(loadQuestionId);
    }
}
