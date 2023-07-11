package dev.chrono.chronochallenge.repository;

import dev.chrono.chronochallenge.model.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
}
