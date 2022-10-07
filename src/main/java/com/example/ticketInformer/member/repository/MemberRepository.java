package com.example.ticketInformer.member.repository;

import com.example.ticketInformer.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
