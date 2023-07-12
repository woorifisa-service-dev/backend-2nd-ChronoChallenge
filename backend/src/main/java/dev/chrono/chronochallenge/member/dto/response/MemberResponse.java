package dev.chrono.chronochallenge.member.dto.response;

import dev.chrono.chronochallenge.member.model.Member;
import lombok.Getter;

@Getter
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
        return new MemberResponse(member.getName(), member.getPoint(), member.getPassTicket());
    }

    public static MemberResponse teacherInfoFrom(Member member) {
        return new MemberResponse(member.getName());
    }
}
