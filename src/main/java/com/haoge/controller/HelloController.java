package com.haoge.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@RequestMapping(value="/hello")
	@ResponseBody
	public String hello() {
		return "hello World";
	}
	
	@RequestMapping(value="/success")
	public String success(Map<String, Object> map) {
		 map.put("hello","你好");
	     map.put("users",Arrays.asList("zhangsan","lisi","wangwu"));
		return "success";
	}

}
