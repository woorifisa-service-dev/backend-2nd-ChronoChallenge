package dev.chrono.chronochallenge.service;

import dev.chrono.chronochallenge.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberService extends CrudService<Member, Long>  {

}
