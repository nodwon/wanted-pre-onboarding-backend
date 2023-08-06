package com.wanted.wantedpreonboardingbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "article")
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @JoinColumn(name = "member_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;// 유저 정보

    @Setter
    @Column(name = "title")
    private String title; // 제목

    @Setter
    @Column(name = "content", length = 10000)
    private String content; // 본문

    private Article(Member member, String title, String content) {
        this.member = member;
        this.title = title;
        this.content = content;
    }
    public static Article of(Member member, String title, String content) {
        return new Article(member, title, content);
    }
}
