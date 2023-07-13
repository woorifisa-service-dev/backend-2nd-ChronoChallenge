package dev.chrono.chronochallenge.quiz.dto.rquest;

import dev.chrono.chronochallenge.quiz.model.Quiz;
import dev.chrono.chronochallenge.quiz.model.QuizStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
public class QuizRequest {

    private String question;
    private int answer;
    private String multipleCandidate1;
    private String multipleCandidate2;
    private String multipleCandidate3;
    private String multipleCandidate4;
    private int point;
    private QuizStatus status;

    @Builder
    public QuizRequest(String question, int answer, String multipleCandidate1, String multipleCandidate2, String multipleCandidate3, String multipleCandidate4, int point, QuizStatus status) {
        this.question = question;
        this.answer = answer;
        this.multipleCandidate1 = multipleCandidate1;
        this.multipleCandidate2 = multipleCandidate2;
        this.multipleCandidate3 = multipleCandidate3;
        this.multipleCandidate4 = multipleCandidate4;
        this.point = point;
        this.status = status;
    }

    public static Quiz toQuiz(QuizRequest quizRequest){
        return Quiz.builder()
                .question(quizRequest.getQuestion())
                .answer(quizRequest.getAnswer())
                .multipleCandidate1(quizRequest.getMultipleCandidate1())
                .multipleCandidate2(quizRequest.getMultipleCandidate2())
                .multipleCandidate3(quizRequest.getMultipleCandidate3())
                .multipleCandidate4(quizRequest.getMultipleCandidate4())
                .point(quizRequest.getPoint())
                .status(quizRequest.getStatus())
                .build();
    }
}
