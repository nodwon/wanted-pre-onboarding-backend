package com.wanted.wantedpreonboardingbackend.controller;

import com.wanted.wantedpreonboardingbackend.common.JwtUtil;
import com.wanted.wantedpreonboardingbackend.domain.UserAccount;
import com.wanted.wantedpreonboardingbackend.dto.SessionRequestDto;
import com.wanted.wantedpreonboardingbackend.dto.SessionResponseDto;
import com.wanted.wantedpreonboardingbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.net.URISyntaxException;

public class SessionController {
    @Autowired
    UserService userService;
    @Autowired
    UserAccount userAccount;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/session")
    public ResponseEntity<SessionResponseDto> create(@RequestBody SessionRequestDto resource) throws URISyntaxException {


        UserAccount user = userService.authenticate(resource.getEmail(), resource.getPassword());
        String accessToken = jwtUtil.createToken(user.getId(), user.getEmail());
        String url ="/session";
        return ResponseEntity.created(new URI(url)).body(SessionResponseDto
                .builder()
                .accessToken(accessToken)
                .build());
    }
}
