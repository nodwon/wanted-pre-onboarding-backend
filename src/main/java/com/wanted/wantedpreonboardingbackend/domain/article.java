package com.wanted.wantedpreonboardingbackend.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Table(name = "article")
public class article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserAccount userAccount;// 유저 정보

    @Setter
    @Column(name = "title")
    private String title; // 제목

    @Setter
    @Column(name = "content", length = 10000)
    private String content; // 본문


}
