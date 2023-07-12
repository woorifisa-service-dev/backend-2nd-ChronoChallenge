package dev.chrono.chronochallenge.dto;

import dev.chrono.chronochallenge.model.Member;

public class MemberResponse {

    private String name;
    private int point;
    private int passTicket;

    public MemberResponse(String name, int point, int passTicket) {
        this.name = name;
        this.point = point;
        this.passTicket = passTicket;
    }

    public MemberResponse(String name) {
        this.name = name;
    }

    public static MemberResponse studentInfoFrom(Member member) {
        final String name = member.getName();
        final int point = member.getPoint();
        final int passTicket = member.getPassTicket();
        return new MemberResponse(name, point, passTicket);
    }

    public static MemberResponse teacherInfoFrom(Member member) {
        final String name = member.getName();
        return new MemberResponse(name);
    }
}
