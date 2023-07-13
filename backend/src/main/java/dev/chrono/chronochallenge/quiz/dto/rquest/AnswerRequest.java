package dev.chrono.chronochallenge.quiz.dto.rquest;

import dev.chrono.chronochallenge.quiz.model.Quiz;
import dev.chrono.chronochallenge.quiz.model.QuizStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AnswerRequest {

    private Long id;
    private int answer;
    private int point;
    private QuizStatus status;

    @Builder
    public AnswerRequest(Long id, int answer, int point, QuizStatus status) {
        this.id = id;
        this.answer = answer;
        this.point = point;
        this.status = status;
    }

    public static Quiz toAnswer(AnswerRequest answerRequest) {
        return Quiz.builder()
                .id(answerRequest.getId())
                .answer(answerRequest.getAnswer())
                .point(answerRequest.getPoint())
                .status(answerRequest.getStatus())
                .build();
    }
}
