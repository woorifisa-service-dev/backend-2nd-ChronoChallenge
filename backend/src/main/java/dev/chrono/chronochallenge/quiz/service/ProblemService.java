package dev.chrono.chronochallenge.quiz.service;

import dev.chrono.chronochallenge.common.dto.MessageResponse;
import dev.chrono.chronochallenge.member.model.Member;
import dev.chrono.chronochallenge.member.service.MemberService;
import dev.chrono.chronochallenge.quiz.dto.rquest.AnswerRequest;
import dev.chrono.chronochallenge.quiz.model.Quiz;
import dev.chrono.chronochallenge.quiz.model.QuizStatus;
import org.springframework.stereotype.Service;

@Service
public class ProblemService {


    MemberService memberService;
    QuizService quizService;

    public ProblemService(MemberService memberService, QuizService quizService) {
        this.memberService = memberService;
        this.quizService = quizService;
    }

    public int checkAnswer(Long quizId, AnswerRequest answerRequest) {
        Quiz quiz = quizService.findById(quizId);
        Member member = memberService.findById(answerRequest.getId());
        int quizAnswer = quiz.getAnswer();
        int quizPoint = quiz.getPoint();
        int answer = 0;


        // 퀴즈를 맞춘 경우 answer = 1
        if(quizAnswer == answerRequest.getAnswer()) {
            int sumPassTicket = 0;
            int sumQuizPoint =  member.getPoint() + quizPoint;
            if(sumQuizPoint >= 100){
                sumQuizPoint -= 100;
                sumPassTicket = member.getPassTicket() + 1;
            }
            QuizStatus quizStatus = QuizStatus.RESOLVED;
            quizService.updateStatusAndAnswerMember(quiz, quizStatus, member);
            memberService.updatePoint(member, sumQuizPoint, sumPassTicket);

            answer = 1;
        }
        // 퀴즈를 맞추지 못한 경우 answer = 0;

        return answer;
    }

    public MessageResponse answerCheck(int answer) {

        MessageResponse messageResponse;

        if(answer == 1) {
            messageResponse = MessageResponse
                    .builder()
                    .message("축하드립니다! 정답입니다!")
                    .code(1)
                    .build();
        } else {
            messageResponse = MessageResponse
                    .builder()
                    .message("아쉽게도 틀리셨습니다 ㅠㅠ")
                    .code(0)
                    .build();
        }
        return messageResponse;
    }
}
