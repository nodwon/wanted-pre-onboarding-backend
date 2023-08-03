package com.wanted.wantedpreonboardingbackend.service;

import com.wanted.wantedpreonboardingbackend.domain.UserAccount;
import com.wanted.wantedpreonboardingbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserAccount Check(UserAccount user){
        validateDuplicateEmail(user); // 이메일 @ 확인
        validateDuplicatePassword(user);
        userRepository.save(user);
        return user;
    }


    private void validateDuplicateEmail(UserAccount user){ // 이메일 @확인
        List<UserAccount> findEmail = userRepository.findByName(user.getEmail());
        if(!findEmail.contains("@")){
            throw new IllegalStateException("@포함되어 있지 않습니다.");
        }
    }
    private void validateDuplicatePassword (UserAccount user){ // 비밀번호 8자이상인지
        List<UserAccount> CorrectPassword = userRepository.findByName(user.getUserPassword());
        if(CorrectPassword.size() <8){
            throw new IllegalStateException("비밀번호가 8자이상이 아닙니다.");
        }
    }
}
