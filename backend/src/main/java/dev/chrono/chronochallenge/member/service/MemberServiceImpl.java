package dev.chrono.chronochallenge.member.service;

import dev.chrono.chronochallenge.member.model.Member;
import dev.chrono.chronochallenge.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements dev.chrono.chronochallenge.member.service.MemberService {

    private MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member findById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }
}
