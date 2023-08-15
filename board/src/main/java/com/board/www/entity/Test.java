package com.board.www.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EnableJpaAuditing
@EntityListeners(AuditingEntityListener.class)
public class Test {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer testId;
   
   @Column(length = 100)
   private String testContents;
   
   @Builder
   public Test(Integer testId, String testContents) {
       this.testId = testId;
       this.testContents = testContents;
   }
}