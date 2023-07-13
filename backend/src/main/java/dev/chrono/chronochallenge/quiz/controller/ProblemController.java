package dev.chrono.chronochallenge.quiz.controller;

import dev.chrono.chronochallenge.common.dto.MessageResponse;
import dev.chrono.chronochallenge.quiz.dto.rquest.AnswerRequest;
import dev.chrono.chronochallenge.quiz.service.ProblemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/quizs")
@RestController
public class ProblemController {


    private ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    // 문제 채점 API
    @Transactional
    @ApiOperation(value = "퀴즈 정답 확인")
    @PostMapping("{id}/answer")
    public ResponseEntity<MessageResponse> getQuizAnswer(@PathVariable(name = "id") Long quizId,
                                                         @RequestBody AnswerRequest answerRequest) {

        int answer = problemService.checkAnswer(quizId, answerRequest);
        MessageResponse messageResponse = problemService.answerCheck(answer);

        return ResponseEntity.status(HttpStatus.OK).body(messageResponse);
    }

}
