package dev.chrono.chronochallenge.quiz.service;

import dev.chrono.chronochallenge.member.model.Member;
import dev.chrono.chronochallenge.quiz.model.Quiz;
import dev.chrono.chronochallenge.quiz.model.QuizStatus;
import dev.chrono.chronochallenge.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService{

    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public List<Quiz> findAll() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz findById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    @Override
    public List<Quiz> findByStatus(QuizStatus quizStatus) {
        return quizRepository.findByStatus(quizStatus);
    }

    @Override
    public Quiz save(Quiz quiz) {
        return quizRepository.save(quiz);
    }


    @Override
    public void deleteById(Long id) {
        quizRepository.deleteById(id);
    }

    public void updateStatusAndAnswerMember(Quiz quiz, QuizStatus quizStatus, Member answerMember) {
        quiz.updateStatusAndAnswerMember(quizStatus, answerMember);
    }
}
