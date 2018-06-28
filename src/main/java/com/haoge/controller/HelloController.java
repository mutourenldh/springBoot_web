package com.haoge.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haoge.exception.UserNotExistException;

@Controller
public class HelloController {
	@RequestMapping(value="/hello")
	@ResponseBody
	public String hello() {
		return "hello World";
	}
	/**
	 * 测试自定义错误信息
	 * @return
	 */
	@RequestMapping(value="/hello2")
	@ResponseBody
	public String hello2(@RequestParam("name") String name) {
		if (name.equals("aaa")) {
			throw new UserNotExistException();
		}
		return "hello World";
	}
	
	@RequestMapping(value="/success")
	public String success(Map<String, Object> map) {
		 map.put("hello","你好");
	     map.put("users",Arrays.asList("zhangsan","lisi","wangwu"));
		return "success";
	}

}
