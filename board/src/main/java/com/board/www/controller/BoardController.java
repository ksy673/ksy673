package com.board.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.www.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
//log 주소
//@S1f4j
public class BoardController {
	
	@GetMapping(value = "/")
	public String main() {
		System.out.println("main (GET) 메소드 실행");
		return "/index";
	}
}
