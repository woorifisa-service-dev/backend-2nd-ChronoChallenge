package dev.chrono.chronochallenge.service;

import dev.chrono.chronochallenge.model.Quiz;
import dev.chrono.chronochallenge.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService{

    private final QuizRepository quizRepository;

    @Autowired
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
    public Quiz save(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public void delete(Quiz quiz) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
