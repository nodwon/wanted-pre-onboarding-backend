package com.wanted.wantedpreonboardingbackend.controller;

import com.wanted.wantedpreonboardingbackend.common.JwtUtil;
import com.wanted.wantedpreonboardingbackend.domain.Member;
import com.wanted.wantedpreonboardingbackend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

public class SessionController {
    @Autowired
    MemberService memberService;
    @Autowired
    Member member;

    @Autowired
    JwtUtil jwtUtil;

//    @PostMapping("/session")
//    public ResponseEntity<SessionResponseDto> create(@RequestBody SessionRequestDto resource) throws URISyntaxException {
//
//
//        Member member = memberService.authenticate(resource.getEmail(), resource.getPassword());
//        String accessToken = jwtUtil.createToken(member.getId(), member.getEmail());
//        String url ="/session";
//        return ResponseEntity.created(new URI(url)).body(SessionResponseDto
//                .builder()
//                .accessToken(accessToken)
//                .build());
//    }
}
