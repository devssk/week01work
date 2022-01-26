package com.h99.week01work.controller;

import com.h99.week01work.domain.Myblog;
import com.h99.week01work.domain.MyblogRepository;
import com.h99.week01work.domain.MyblogRequestDto;
import com.h99.week01work.service.MyblogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class MyblogController {

    private final MyblogRepository myblogRepository;
    private final MyblogService myblogService;

    //포스트
    @PostMapping("/api/comments")
    public Myblog creatComment(@RequestBody MyblogRequestDto requestDto){
        Myblog myblog = new Myblog(requestDto);
        return myblogRepository.save(myblog);
    }

    //전체리스트 겟
    @GetMapping("/api/comments")
    public List<Myblog> readcomment(){
        return myblogRepository.findAllByOrderByCreatedAtDesc();
    }

    //id 1개만 불러와 겟
    @GetMapping("/api/comments/{id}")
    public Optional<Myblog> readOneComment(@PathVariable Long id){
        return myblogRepository.findById(id);
    }

    //풋
    @PutMapping("/api/comments/{id}")
    public Long updateMyblog(@PathVariable Long id, @RequestBody MyblogRequestDto requestDto){
        myblogService.update(id, requestDto);
        return id;
    }

    //딜리트
    @DeleteMapping("/api/comments/{id}")
    public Long deleteComment(@PathVariable Long id){
        myblogRepository.deleteById(id);
        return id;
    }

}
