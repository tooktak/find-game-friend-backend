package com.tooktak.findgamefriend.infrastructure;

import com.tooktak.findgamefriend.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member getByMemberId(String id);
}
