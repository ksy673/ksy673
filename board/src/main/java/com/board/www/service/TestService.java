package com.board.www.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.board.www.dto.TestDto;
import com.board.www.repository.TestRepository;

import lombok.RequiredArgsConstructor;

@Service
@Component
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;
    
    public TestService (TestRepository testRepository) {
    	this.testRepository = testRepository;
    
    }

    public TestDto testServiceMethod(String str) {
        TestDto testDto = new TestDto(str);
        return testDto;
    }
}
