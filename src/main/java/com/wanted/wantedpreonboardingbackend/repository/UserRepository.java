package com.wanted.wantedpreonboardingbackend.repository;

import com.wanted.wantedpreonboardingbackend.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserAccount,Long> {

    Optional<UserAccount> findByEmail(String email);
}
