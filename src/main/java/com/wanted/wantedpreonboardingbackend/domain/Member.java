package com.wanted.wantedpreonboardingbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wanted.wantedpreonboardingbackend.domain.Article;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @NotNull
    @Setter
    private String email;

    @NotNull
    @Setter
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Article> articles = new ArrayList<>();

}
