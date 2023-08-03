package com.wanted.wantedpreonboardingbackend.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString(callSuper = true)
@Table(name = "user_account")
@Entity
public class UserAccount {

    @Id
    @Column(length = 50,name = "user_id", unique = true)
    private long id;

    @Column(length = 100, name = "email" ,unique = true)
    private String email;

    @Setter
    @Column(nullable = false,name="user_password") private String userPassword;

}
