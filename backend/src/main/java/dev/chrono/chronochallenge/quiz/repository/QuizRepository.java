package dev.chrono.chronochallenge.quiz.repository;

import dev.chrono.chronochallenge.quiz.model.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Long> {

    List<Quiz> findAll();
}
