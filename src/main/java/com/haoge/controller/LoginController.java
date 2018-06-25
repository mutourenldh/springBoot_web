package com.haoge.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	
	@PostMapping(value="/user/login")
	public String login(@RequestParam("username") String username
			,@RequestParam("password")String password,HttpSession session) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		if (!StringUtils.isEmpty("username")&&password.equals("123456")) {//登录成功
			session.setAttribute("loginUser", username);
			return "redirect:main.html";//登录成功，重定向到main.html
			
		}else {
			map.put("msg", "账号或者密码错误！");
			return "login";
		}
	}
}
