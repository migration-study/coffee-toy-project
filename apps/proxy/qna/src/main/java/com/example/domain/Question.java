package com.example.domain;

import com.example.CannotDeleteException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Question {
    private Long id;
    private String title;
    private String contents;
    private NsUser writer;
    private List<Answer> answers = new ArrayList<>();
    private boolean deleted = false;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime updatedDate;

    public Question() {}

    public Question(NsUser writer, String title, String contents) {
        this(0L, writer, title, contents);
    }

    public Question(Long id, NsUser writer, String title, String contents) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
    }
    public Question setTitle(String title) {
        this.title = title;
        return this;
    }

    public Question setContents(String contents) {
        this.contents = contents;
        return this;
    }

    public void addAnswer(Answer answer) {
        answer.toQuestion(this);
        answers.add(answer);
    }

    public boolean isOwner(NsUser loginUser) {
        return writer.equals(loginUser);
    }

    public Question setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public void updateToDelete(List<DeleteHistory> deleteHistories) {
        deleted = true;
        deleteHistories.add(new DeleteHistory(ContentType.QUESTION, id, writer, LocalDateTime.now()));

        for (Answer answer : answers) {
            answer.setDeleted(true);
            deleteHistories.add(new DeleteHistory(ContentType.ANSWER, answer.getId(), answer.getWriter(), LocalDateTime.now()));
        }
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void checkCanDelete(NsUser loginUser) throws CannotDeleteException {
        checkOwner(loginUser);
        checkAnswersOwner(loginUser);
    }

    private void checkOwner(NsUser loginUser) throws CannotDeleteException {
        if (!writer.matchUser(loginUser)) {
            throw new CannotDeleteException("질문을 삭제할 권한이 없습니다.");
        }
    }

    private void checkAnswersOwner(NsUser loginUser) throws CannotDeleteException {
        boolean hasNonOwner = answers.stream()
                .anyMatch(answer -> !answer.isOwner(loginUser));

        if (hasNonOwner) {
            throw new CannotDeleteException("다른 사람이 쓴 답변이 있어 삭제할 수 없습니다.");
        }
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public NsUser getWriter() {
        return writer;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        return "Question [id=" + getId() + ", title=" + title + ", contents=" + contents + ", writer=" + writer + "]";
    }
}