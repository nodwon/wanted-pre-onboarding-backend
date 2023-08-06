package com.wanted.wantedpreonboardingbackend.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "article")
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="article_id")
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

    @Builder
    private Article(Member member, String title, String content) {
        this.member = member;
        this.title = title;
        this.content = content;
    }

}
