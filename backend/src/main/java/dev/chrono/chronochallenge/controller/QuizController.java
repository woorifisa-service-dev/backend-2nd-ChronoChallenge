package dev.chrono.chronochallenge.controller;

import dev.chrono.chronochallenge.dto.response.QuizResponse;
import dev.chrono.chronochallenge.model.Quiz;
import dev.chrono.chronochallenge.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/quizs")
@RestController
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping()
    public List<QuizResponse> getQuizList(){
        return quizService.findAll()
                .stream()
                .map(QuizResponse::From)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public QuizResponse getQuiz(@PathVariable Long id){
        Quiz quiz = quizService.findById(id);
        return QuizResponse.From(quiz);
    }

}

