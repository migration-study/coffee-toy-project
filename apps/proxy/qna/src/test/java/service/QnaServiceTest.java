package service;

import com.example.domain.entity.Answer;
import com.example.domain.entity.Question;
import com.example.domain.repository.QuestionRepository;
import com.example.application.service.question.DeleteQuestionUseCase;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class QnaServiceTest {
    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private DeleteQuestionUseCase deleteUseCase;

    @InjectMocks
//    private QuestionUseCase questionUseCase;

    private Question question;
    private Answer answer;

//    @BeforeEach
//    public void setUp() throws Exception {
//        question = new Question(1L, NsUserTest.JAVAJIGI, "title1", "contents1");
//        answer = new Answer(11L, NsUserTest.JAVAJIGI, QuestionTest.Q1, "Answers Contents1");
//        question.addAnswer(answer);
//    }
//
//    @Test
//    public void delete_성공() throws Exception {
//        when(questionRepository.findById(question.getId())).thenReturn(Optional.of(question));
//
//        assertThat(question.isDeleted()).isFalse();
//        qnAService.deleteQuestion(NsUserTest.JAVAJIGI, question.getId());
//
//        assertThat(question.isDeleted()).isTrue();
//        verifyDeleteHistories();
//    }
//
//    @Test
//    public void delete_다른_사람이_쓴_글() throws Exception {
//        when(questionRepository.findById(question.getId())).thenReturn(Optional.of(question));
//
//        assertThatThrownBy(() -> {
//            qnAService.deleteQuestion(NsUserTest.SANJIGI, question.getId());
//        }).isInstanceOf(CannotDeleteException.class);
//    }
//
//    @Test
//    public void delete_성공_질문자_답변자_같음() throws Exception {
//        when(questionRepository.findById(question.getId())).thenReturn(Optional.of(question));
//
//        qnAService.deleteQuestion(NsUserTest.JAVAJIGI, question.getId());
//
//        assertThat(question.isDeleted()).isTrue();
//        assertThat(answer.isDeleted()).isTrue();
//        verifyDeleteHistories();
//    }
//
//    @Test
//    @Disabled
//    public void delete_답변_중_다른_사람이_쓴_글() throws Exception {
//        when(questionRepository.findById(question.getId())).thenReturn(Optional.of(question));
//
//        assertThatThrownBy(() -> {
//            qnAService.deleteQuestion(NsUserTest.SANJIGI, question.getId());
//        }).isInstanceOf(CannotDeleteException.class);
//    }
//
//    private void verifyDeleteHistories() {
//        List<DeleteHistory> deleteHistories = Arrays.asList(
//                new DeleteHistory(ContentType.QUESTION, question.getId(), question.getWriter(), LocalDateTime.now()),
//                new DeleteHistory(ContentType.ANSWER, answer.getId(), answer.getWriter(), LocalDateTime.now()));
//        verify(deleteHistoryService).saveAll(deleteHistories);
//    }
}
