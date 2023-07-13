package dev.chrono.chronochallenge.quiz.model;

import dev.chrono.chronochallenge.member.model.Member;
import dev.chrono.chronochallenge.quiz.dto.rquest.QuizRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;


@Getter
@Entity
@NoArgsConstructor
@Table
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column
    private String question;

    @Column
    private int answer;

    @Column(name="multiple_candidate1")
    private String multipleCandidate1;

    @Column(name="multiple_candidate2")
    private String multipleCandidate2;

    @Column(name="multiple_candidate3")
    private String multipleCandidate3;

    @Column(name = "multiple_candidate4")
    private String multipleCandidate4;

    @Column
    private int point;

    @Column
    private QuizStatus status;

    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "modified_at")
    private Date modifiedAt;


    @Builder
    public Quiz(Long id, Member member, String question, int answer, String multipleCandidate1, String multipleCandidate2, String multipleCandidate3, String multipleCandidate4, int point, QuizStatus status, Date createdAt, Date modifiedAt) {
        this.id = id;
        this.member = member;
        this.question = question;
        this.answer = answer;
        this.multipleCandidate1 = multipleCandidate1;
        this.multipleCandidate2 = multipleCandidate2;
        this.multipleCandidate3 = multipleCandidate3;
        this.multipleCandidate4 = multipleCandidate4;
        this.point = point;
        this.status = status;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public void update(QuizRequest quizRequest){
        this.question = quizRequest.getQuestion();
        this.answer = quizRequest.getAnswer();
        this.multipleCandidate1 = quizRequest.getMultipleCandidate1();
        this.multipleCandidate2 = quizRequest.getMultipleCandidate2();
        this.multipleCandidate3 = quizRequest.getMultipleCandidate3();
        this.multipleCandidate4 = quizRequest.getMultipleCandidate4();
        this.point = quizRequest.getPoint();
        this.status = quizRequest.getStatus();
    }
}
