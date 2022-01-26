package com.h99.week01work.service;

import com.h99.week01work.domain.Myblog;
import com.h99.week01work.domain.MyblogRepository;
import com.h99.week01work.domain.MyblogRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MyblogService {

    private final MyblogRepository myblogRepository;

    @Transactional
    public Long update(Long id, MyblogRequestDto requestDto){
        Myblog myblog = myblogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        myblog.update(requestDto);
        return myblog.getId();
    }
}
