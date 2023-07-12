package dev.chrono.chronochallenge.quiz.dto.response;

import dev.chrono.chronochallenge.quiz.model.Quiz;
import lombok.Builder;
import lombok.Getter;

@Getter
public class QuizResponse {

    private String question;
    private int answer;
    private String multipleCandidate1;
    private String multipleCandidate2;
    private String multipleCandidate3;
    private String multipleCandidate4;
    private int point;
    private boolean status;

    @Builder
    public QuizResponse(String question, int answer, String multipleCandidate1, String multipleCandidate2, String multipleCandidate3, String multipleCandidate4, int point, boolean status) {
        this.question = question;
        this.answer = answer;
        this.multipleCandidate1 = multipleCandidate1;
        this.multipleCandidate2 = multipleCandidate2;
        this.multipleCandidate3 = multipleCandidate3;
        this.multipleCandidate4 = multipleCandidate4;
        this.point = point;
        this.status = status;
    }

    public static QuizResponse From(Quiz quiz){
        return QuizResponse.builder()
                .question(quiz.getQuestion())
                .answer(quiz.getAnswer())
                .multipleCandidate1(quiz.getMultipleCandidate1())
                .multipleCandidate2(quiz.getMultipleCandidate2())
                .multipleCandidate3(quiz.getMultipleCandidate3())
                .multipleCandidate4(quiz.getMultipleCandidate4())
                .point(quiz.getPoint())
                .status(quiz.isStatus())
                .build();
    }
}
