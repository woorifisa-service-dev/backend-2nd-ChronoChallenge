package dev.chrono.chronochallenge.quiz.service;

import dev.chrono.chronochallenge.common.service.CrudService;
import dev.chrono.chronochallenge.member.model.Member;
import dev.chrono.chronochallenge.quiz.model.Quiz;
import dev.chrono.chronochallenge.quiz.model.QuizStatus;

public interface QuizService extends CrudService<Quiz, Long> {
    void updateStatusAndAnswerMember(Quiz quiz, QuizStatus quizStatus, Member answerMember);

}
