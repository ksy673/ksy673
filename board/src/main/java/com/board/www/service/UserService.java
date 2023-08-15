package com.board.www.service;

import org.springframework.stereotype.Service;

import com.board.www.dto.UserDto;
import com.board.www.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

public int joinUser(UserDto userDto) {
	int result = userRepository.joinUser(userDto);
	return result;
	}

public String idCheck(String userId) {
	System.out.println("idCheck service 실행");
	String idChecked = userRepository.idCheck(userId);
	
	return idChecked;
	}

public UserDto login(UserDto userDto) {
	String userId = userDto.getUserId();
	UserDto userInfo = userRepository.login(userId);
	
	if(userDto.getUserPassword().equals(userInfo.getUserPassword())) {
		// 비밀번호가 맞았으면 비밀번호를 가려준다.
		userInfo.setUserPassword("");
	} else {
		
		// 비밀번호가 틀렸으면 아이디를 "n"로 구분
		userInfo.setUserId("n");
		userInfo.setUserPassword("");
	}
	
	return userInfo;
	}

}
