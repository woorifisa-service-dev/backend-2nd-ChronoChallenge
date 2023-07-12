package dev.chrono.chronochallenge.controller;

import dev.chrono.chronochallenge.dto.response.MemberResponse;
import dev.chrono.chronochallenge.model.Member;
import dev.chrono.chronochallenge.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public

@RequestMapping("/member")
@RestController
class MemeberController {
    private MemberService memberService;
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponse> showMemberInfo(@PathVariable Long memberId) {
        Member member = memberService.findById(memberId);
        if(memberId == 1) {
            return new ResponseEntity<>(MemberResponse.teacherInfoFrom(member), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(MemberResponse.studentInfoFrom(member), HttpStatus.OK);
        }
    }
}
