package com.example.demo.service;

import com.example.demo.dto.MemberFormDTO;
import com.example.demo.entity.Member;
import com.example.demo.entity.Role;
import com.example.demo.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입 로직 (중복성 검사, 비밀번호 확인)
    public void join(MemberFormDTO memberForm, BindingResult result) {
        if (memberRepository.existsByEmail(memberForm.getEmail())) {
            result.rejectValue("email", "error.email", "이미 사용 중인 이메일입니다.");
        }

        if (memberRepository.existsByNick(memberForm.getNick())) {
            result.rejectValue("nick", "error.nick", "이미 사용 중인 아이디입니다.");
        }

        // 비밀번호와 비밀번호 확인이 일치하는지 검사
        if (!memberForm.getPassword().equals(memberForm.getPasswordConfirm())) {
            result.rejectValue("passwordConfirm", "error.passwordConfirm", "비밀번호가 일치하지 않습니다.");
        }
        
        if (memberRepository.existsByPhonenumber(memberForm.getPhonenumber())) {
            result.rejectValue("phonenumber", "error.phonenumber", "이미 사용 중인 휴대전화 번호입니다.");
        }
        
        if (result.hasErrors()) {
            return; // 오류가 있을 경우 메서드를 종료
        }

     // 회원가입 로직
        Member member = Member.builder()
                .nick(memberForm.getNick())
                .email(memberForm.getEmail())
                .username(memberForm.getUsername())
                .password(memberForm.getPassword())
                .phonenumber(memberForm.getPhonenumber())
                .role(Role.USER) // 기본 권한 설정
                .build();

        memberRepository.save(member);

    }
 // 회원 삭제 로직
    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다. ID: " + id));

        memberRepository.delete(member);
    }


 // 모든 회원 조회 로직
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }
    
//특정 회원 조회 로직
public Member findMemberById(Long id) {
    return memberRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다. ID: " + id));
}

public Member login(String nick, String password) {
    Member member = memberRepository.findByNick(nick)
            .orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 올바르지 않습니다."));
    if (!member.getPassword().equals(password)) {
        throw new IllegalArgumentException("아이디 또는 비밀번호가 올바르지 않습니다.");
    }
    return member;
}
}
