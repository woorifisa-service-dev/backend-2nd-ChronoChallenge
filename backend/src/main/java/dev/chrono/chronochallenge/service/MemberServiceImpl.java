package dev.chrono.chronochallenge.service;

import dev.chrono.chronochallenge.model.Member;
import dev.chrono.chronochallenge.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> findAll() {
        return null;
    }

    @Override
    public Member findById(Long aLong) {
        return null;
    }

    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public void delete(Member member) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
