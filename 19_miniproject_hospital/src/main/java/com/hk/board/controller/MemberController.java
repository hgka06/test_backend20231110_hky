package com.hk.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hk.board.command.AddUserCommand;
import com.hk.board.command.LoginCommand;


@Controller
@RequestMapping(value = "/user")
public class MemberController {
   
   @GetMapping(value = "/addUser")
   public String addUserForm(Model model) {
      System.out.println("회원가입폼 이동");
      
      //회원가입폼에서 addUserCommand객체를 사용하는 코드가 작성되어 있어서 
      //null일경우 오류가 발생하기때문에 보내줘야 함
      model.addAttribute("addUserCommand", new AddUserCommand());
      
      return "member/addUserForm";
   }
   
   //로그인 폼 이동
   @GetMapping(value = "/login")
   public String loginForm(Model model) {
      model.addAttribute("loginCommand", new LoginCommand());
      return "member/login";
   }
   
}