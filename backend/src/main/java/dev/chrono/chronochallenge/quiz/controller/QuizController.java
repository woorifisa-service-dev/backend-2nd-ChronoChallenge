package dev.chrono.chronochallenge.quiz.controller;

import dev.chrono.chronochallenge.quiz.dto.response.QuizResponse;
import dev.chrono.chronochallenge.quiz.dto.rquest.QuizRequest;
import dev.chrono.chronochallenge.quiz.model.Quiz;
import dev.chrono.chronochallenge.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public ResponseEntity<QuizResponse> saveQuiz(@RequestBody QuizRequest quizRequest){
        Quiz quiz = QuizRequest.toQuiz(quizRequest);
        Quiz saveQuiz = quizService.save(quiz);
        QuizResponse quizResponse = QuizResponse.From(saveQuiz);
        return ResponseEntity.status(HttpStatus.OK).body(quizResponse);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<QuizResponse> updateQuiz(@PathVariable Long id, @RequestBody QuizRequest quizRequest){
        Quiz quiz = quizService.findById(id);
        quiz.update(quizRequest);
        QuizResponse quizResponse = QuizResponse.From(quiz);

        return ResponseEntity.status(HttpStatus.OK).body(quizResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<QuizResponse> deleteQuiz(@PathVariable Long id){
        QuizResponse quiz = QuizResponse.From(quizService.findById(id));
        quizService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body(quiz);
    }

}

