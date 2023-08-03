package com.wanted.wantedpreonboardingbackend.service;

import com.wanted.wantedpreonboardingbackend.Exception.EmailExistedException;
import com.wanted.wantedpreonboardingbackend.Exception.PasswordWrongException;
import com.wanted.wantedpreonboardingbackend.domain.UserAccount;
import com.wanted.wantedpreonboardingbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository =userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public UserAccount join(UserAccount user){
        validateEmail(user); // 이메일 @ 확인
        validatePassword(user);
        encryptPasswordAndSave(user);
        return userRepository.save(user);

    }


    private void validateEmail(UserAccount user){ // 이메일 @확인
        String email = user.getEmail();
        if(!email.contains("@")){
            throw new IllegalStateException("@포함되어 있지 않습니다.");
        }
    }
    private void validatePassword (UserAccount user){ // 비밀번호 8자이상인지랑 b
        String password = user.getUserPassword();
        if(password.length() <8){
            throw new IllegalStateException("비밀번호가 8자이상이 아닙니다.");
        }

    }
    public void encryptPasswordAndSave(UserAccount user) {
        String password = user.getUserPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setUserPassword(encodedPassword);
        userRepository.save(user);
    }

    public UserAccount authenticate(String email, String password) {
        UserAccount user = userRepository.findByEmail(email)
                .orElseThrow(()->new EmailExistedException(email));

        // ***** 패스워드값 확인 부분 ****
        if(!passwordEncoder.matches(password, user.getUserPassword())){
            throw new PasswordWrongException();
        }
        return user;
    }
}
