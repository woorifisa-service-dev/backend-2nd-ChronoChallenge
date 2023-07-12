package dev.chrono.chronochallenge.quiz.controller;

import dev.chrono.chronochallenge.quiz.dto.response.QuizResponse;
import dev.chrono.chronochallenge.quiz.dto.rquest.QuizRequest;
import dev.chrono.chronochallenge.quiz.model.Quiz;
import dev.chrono.chronochallenge.quiz.service.QuizService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @ApiOperation(value = "퀴즈 전체 목록 조회")
    @GetMapping
    public List<QuizResponse> getQuizList(){
        return quizService.findAll()
                .stream()
                .map(QuizResponse::From)
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "퀴즈 조회")
    @GetMapping("/{id}")
    public QuizResponse getQuiz(
            @ApiParam(value = "퀴즈 아이디", required = true, example = "1") @PathVariable Long id
    ){
        Quiz quiz = quizService.findById(id);
        return QuizResponse.From(quiz);
    }

    @ApiOperation(value = "퀴즈 추가")
    @PostMapping("/add")
    public ResponseEntity<QuizResponse> saveQuiz(
            @ApiParam(value = "추가할 퀴즈 정보", required = true, example = "1") @RequestBody QuizRequest quizRequest
    ){
        Quiz quiz = QuizRequest.toQuiz(quizRequest);
        Quiz saveQuiz = quizService.save(quiz);
        QuizResponse quizResponse = QuizResponse.From(saveQuiz);
        return ResponseEntity.status(HttpStatus.OK).body(quizResponse);
    }

    @ApiOperation(value = "퀴즈 수정")
    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<QuizResponse> updateQuiz(
            @ApiParam(value = "퀴즈 아이디", required = true, example = "1") @PathVariable Long id,
            @ApiParam(value = "수정할 퀴즈 정보", required = true, example = "1") @RequestBody QuizRequest quizRequest
    ){
        Quiz quiz = quizService.findById(id);
        quiz.update(quizRequest);
        QuizResponse quizResponse = QuizResponse.From(quiz);

        return ResponseEntity.status(HttpStatus.OK).body(quizResponse);
    }

    @ApiOperation(value = "퀴즈 삭제")
    @DeleteMapping("/{id}")
    public ResponseEntity<QuizResponse> deleteQuiz(
            @ApiParam(value = "퀴즈 아이디", required = true, example = "1") @PathVariable Long id
    ){
        QuizResponse quiz = QuizResponse.From(quizService.findById(id));
        quizService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body(quiz);
    }

}

