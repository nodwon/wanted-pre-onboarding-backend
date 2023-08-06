package com.wanted.wantedpreonboardingbackend.service;

import com.wanted.wantedpreonboardingbackend.controller.MemberForm;
import com.wanted.wantedpreonboardingbackend.domain.Member;
import com.wanted.wantedpreonboardingbackend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder){
        this.memberRepository =memberRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public Long createMember(MemberForm memberForm) {
        // MemberForm으로부터 필요한 정보 추출하여 Member 엔티티 생성
        Member member = new Member();
        member.setEmail(memberForm.getEmail());
        member.setPassword(memberForm.getPassword()); // 이 부분은 암호화 등의 추가 작업이 필요할 수 있습니다.
        validateEmail(member); // 이메일 @ 확인
        validatePassword(member);
        // Member 엔티티 저장
        memberRepository.save(member);
        return member.getId();
    }


    private void validateEmail(Member member){ // 이메일 @확인
        String email = member.getEmail();
        if(!email.contains("@")){
            throw new IllegalStateException("@포함되어 있지 않습니다.");
        }
    }
    private void validatePassword (Member member){ // 비밀번호 8자이상인지랑 b
        String password = member.getPassword();
        if(password.length() <8){
            throw new IllegalStateException("비밀번호가 8자이상이 아닙니다.");
        }
        else {
            String encodedPassword = passwordEncoder.encode(password);
            member.setPassword(encodedPassword);
            memberRepository.save(member);
        }

    }

//    public Member authenticate(String email, String password) {
//        Member member = memberRepository.findByEmail(email)
//         .orElseThrow(()->new EmailExistedException(email));
//
//        // ***** 패스워드값 확인 부분 ****
//        if(!passwordEncoder.matches(password, member.getPassword())){throw new PasswordWrongException();
//        }
//        return member;
//    }
}
