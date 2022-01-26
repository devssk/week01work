package com.h99.week01work.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Myblog extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String comments;

    public Myblog(String username, String title, String comments){
        this.username = username;
        this.title = title;
        this.comments = comments;
    }

    public Myblog(MyblogRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.comments = requestDto.getComments();
    }

    public void update(MyblogRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.comments = requestDto.getComments();
    }

}
