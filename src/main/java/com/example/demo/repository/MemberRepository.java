package com.example.demo.repository;

import com.example.demo.entity.Member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
	boolean existsByEmail(String email);
    boolean existsByNick(String usernick);
    boolean existsByPhonenumber(String phonenumber);
    
    Optional<Member> findByEmail(String email);
    Optional<Member> findByNick(String nick);
}

