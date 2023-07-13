package dev.chrono.chronochallenge.auth.service;

import dev.chrono.chronochallenge.auth.dto.AuthInfo;
import dev.chrono.chronochallenge.auth.dto.MessageResponse;
import dev.chrono.chronochallenge.auth.dto.request.LoginRequest;
import dev.chrono.chronochallenge.auth.exception.LoginFailedException;
import dev.chrono.chronochallenge.member.model.Member;
import dev.chrono.chronochallenge.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class AuthService {
    private MemberRepository memberRepository;
    public AuthService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public AuthInfo login(LoginRequest loginRequest) {
        /*
        public AuthInfo login()
        AuthService에서 기존에 회원가입한 맴버 정보를 memberRepository를 통해 받아온다.
        받아오면서 AuthInfo 클래스에 객체에 담겨주고, 그것을 새로운 객체를 생성하면서 넘겨준다.
         */
        String name = loginRequest.getName();
        String password = loginRequest.getPassword();
        Member member = memberRepository.findByNameAndPassword(name, password).orElseThrow(LoginFailedException::new);
        return new AuthInfo(member.getId(),member.getName());
    }

    public MessageResponse loginCheck(HttpSession session) {

        MessageResponse messageResponse;

        if(null == session.getAttribute("memberId")) {
            messageResponse = MessageResponse
                    .builder()
                    .message("로그인 상태가 아닙니다.")
                    .code(0)
                    .build();
        } else {
            AuthInfo authInfo = (AuthInfo) session.getValue("memberId");
            messageResponse = MessageResponse
                    .builder()
                    .message(authInfo.getName() + "님이 로그인한 상태입니다.")
                    .code(1)
                    .build();
        }

        return messageResponse;
    }

}
