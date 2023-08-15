package com.board.www.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.www.dto.UserDto;
import com.board.www.service.UserService;

//@S1f4j
@RequestMapping(value = "/user")
@Controller
public class UserController {
	@Autowired
  UserService userService;

   // 회원 가입 페이지 이동
   @GetMapping(value = "/join")
   public String join() {
      System.out.println("join(GET) 메소드 실행");
      return "/user/join";
   }
   
   @GetMapping(value = "/userUpdate")
   public String userUpdate(Model model, HttpServletRequest request) {
      System.out.println("userUpdate(GET) 메소드 실행");
      HttpSession session = request.getSession();
      UserDto userInfo = (UserDto) session.getAttribute("userInfo");
      
      model.addAttribute("userInfo",userInfo);
      
      return "/user/userUpdate";
   }
   
   @PostMapping(value = "/login")
   public String login(UserDto userDto, HttpServletRequest request, Model model) {
	   UserDto loginUser = userService.login(userDto);
	   
	   if (loginUser == null) {
		   //로그인 실패
		   model.addAttribute("msg", "로그인 실패");
		   return "/index";
	   }
	   
	   HttpSession session = request.getSession();
	   
	   session.setAttribute("userInfo", loginUser);
	   
	   model.addAttribute("msg", "로그인 성공");
	   
	   return "/index";
   }
   
   // ID중복 체크
   @ResponseBody
   @GetMapping(value = "/idCheck")
   public String idCheck(String userId) {
	   System.out.println("idCheck(GET) 메소드 실행");
	   System.out.println("userId = {}" + userId);
	   String idChecked = userService.idCheck(userId);
	   
	   String result = "yes";
	   
	   if (idChecked != null) {
		   result = "no";
	   }
	   return result;
   }
   
   //회원 등록
   @ResponseBody
   @PostMapping(value = "/join")
   public int join(UserDto userDto, Model model) {
	   // int 타입으로 반환값을 받음
	   int result = userService.joinUser(userDto);
	   
	   return result;

   }
   @GetMapping(value ="/check")
   public String text() {
	   
	   return "/user/javascript";
   }
   
}