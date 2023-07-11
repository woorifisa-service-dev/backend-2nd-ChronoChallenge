package dev.chrono.chronochallenge.controller;

import dev.chrono.chronochallenge.service.MemberService;

public class MemeberController {
   private MemberService memberService;

    public MemeberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
