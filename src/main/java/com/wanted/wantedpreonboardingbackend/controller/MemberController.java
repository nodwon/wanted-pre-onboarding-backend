package com.wanted.wantedpreonboardingbackend.controller;

import com.wanted.wantedpreonboardingbackend.domain.Member;
import com.wanted.wantedpreonboardingbackend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    @GetMapping("/signup")
    public String createFrom(Model model){
        model.addAttribute("memberForm", new MemberForm());
        return "member/createMemberForm";
    }
    @PostMapping("/signup")
    public String create(@Valid MemberForm memberForm, BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                return "member/createMemberForm"; // 폼 유효성 검사에 실패하면 다시 폼을 보여줍니다.
            }
            // 폼 데이터가 유효하면 회원 생성 로직을 수행합니다.
            memberService.createMember(memberForm);

        return "redirect:/home";
    }

}
