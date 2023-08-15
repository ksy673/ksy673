package com.board.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.board.www.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
}