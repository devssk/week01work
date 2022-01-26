package com.h99.week01work.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyblogRepository extends JpaRepository<Myblog, Long> {
    List<Myblog> findAllByOrderByCreatedAtDesc();
}
