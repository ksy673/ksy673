package com.board.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.www.service.TestService;

import lombok.RequiredArgsConstructor;

@Controller //컨트롤러 클래스 하위 메서드에 @ResponseBody 어노테이션을 붙이지 않아도 문자열과 JSON 등을 전송할 수 있습니다. 
//@RequiredArgsConstructor //Lombok으로 스프링에서 DI(의존성 주입)의 방법 중에 생성자 주입을 임의의 코드없이 자동으로 설정해주는 어노테이션이다.
public class TestController {
	
   private final TestService testService;
   
   public TestController (TestService testService) {
	   this.testService = testService;
   }
   
   
   public String helloWorld(Model model) {
      System.out.println("helloWorld 메소드 실행");
      model.addAttribute("message","Hello World!!");
       return "index.html";
}

}
