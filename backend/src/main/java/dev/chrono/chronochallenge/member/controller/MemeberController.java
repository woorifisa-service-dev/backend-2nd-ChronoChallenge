package dev.chrono.chronochallenge.member.controller;

import dev.chrono.chronochallenge.member.dto.response.MemberResponse;
import dev.chrono.chronochallenge.member.model.Member;
import dev.chrono.chronochallenge.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
