package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.MemberFormDTO;
import com.example.demo.entity.Member;
import com.example.demo.entity.Role;
import com.example.demo.service.MemberService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    
    //회원가입 폼 
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("memberForm", new MemberFormDTO()); // 여기서 memberForm 추가
        return "register"; // 템플릿 이름
    }
    
    //회원가입 처리
    @PostMapping("/register")
    public String registerMember(@ModelAttribute("memberForm") @Valid MemberFormDTO memberForm, BindingResult result) {
        memberService.join(memberForm, result); // 오류를 처리하도록 수정
        if (result.hasErrors()) {
            return "register"; // 에러가 있을 경우 다시 폼으로
        }
        return "redirect:/hello"; // 성공 후 리디렉션
    }

    // **회원가입 성공 페이지**
    @GetMapping("/hello")
    public String registrationSuccess() {
        return "hello"; // 성공 페이지 반환
    }
    // **회원 목록 보기**
    @GetMapping("/members")
    public String listMembers(Model model) {
        model.addAttribute("members", memberService.findAllMembers()); // 모든 회원 가져오기
        return "memberlist"; // 회원 목록 페이지 템플릿
    }
    
    // 회원 삭제 기능 추가
    @PostMapping("/members/delete/{id}")
    public String deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return "redirect:/delete-success"; // 삭제 성공 후 리디렉션
    }

    // 회원 삭제 성공 페이지
    @GetMapping("/delete-success")
    public String deleteSuccess() {
        return "delete-success"; // 회원삭제 성공 페이지 반환
    }
    
    // 회원 조회 기능 추가
    @GetMapping("/members/{id}")
    public String viewMember(@PathVariable Long id, Model model) {
        Member member = memberService.findMemberById(id);
        model.addAttribute("member", member);
        return "member-detail"; // 회원 상세 페이지 템플릿
    }
    
    @PostMapping("/signin")
    public String signin(
            @RequestParam String nick,
            @RequestParam String password,
            RedirectAttributes redirectAttributes,
            HttpSession session) {
        try {
            // 로그인 검증
            Member member = memberService.login(nick, password);

            // 세션에 사용자 정보 저장
            session.setAttribute("loggedInUser", member.getNick());
            session.setAttribute("memberId", member.getId());
            session.setAttribute("role", member.getRole());

            // 역할에 따라 리다이렉션
            if (member.getRole() == Role.ADMIN) {
                return "redirect:/a_index"; // 관리자 페이지로 리디렉션
            } else {
                return "redirect:/index"; // 일반 사용자 페이지로 리디렉션
            }
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/signin"; // 로그인 실패 시 로그인 페이지로 돌아감
        }
    }

    @GetMapping("/a_index")
    public String adminPage(HttpSession session) {
        // 세션에서 role 정보를 가져옴
        Role role = (Role) session.getAttribute("role");

        // 세션에 로그인 정보가 없거나, 일반 유저인 경우 접근을 막음
        if (role == null || role != Role.ADMIN) {
            return "redirect:/access-denied";  // 권한이 없으면 접근 거부 페이지로 이동
        }

        // 관리자 권한이 있는 경우 관리자 페이지로 이동
        return "a_index";  // a_index.html 페이지로 이동
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 무효화 (모든 세션 속성 제거)
        return "redirect:/index"; // 로그아웃 후 메인 페이지로 리디렉션
    }

    
    @GetMapping("/signin")
    public String showSignInPage(Model model) {
        return "signin";
    }
    
    @GetMapping("/mypage")
    public String showMypage(Model model) {
        return "mypage";
    }
    
    @GetMapping("/manager")
    public String manager (Model model) {   
        return "manager"; 
    }


}
