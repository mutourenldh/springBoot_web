package com.haoge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.haoge.component.LoginHandlerInterceptor;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter{
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/haoge").setViewName("success");
	}
	//所有的WebMvcConfigurerAdapter组件都会一起起作用
	@Bean
	public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
		
		WebMvcConfigurerAdapter adapter=new WebMvcConfigurerAdapter(){
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/").setViewName("login");
				registry.addViewController("/index.html").setViewName("login");
				registry.addViewController("/main.html").setViewName("dashboard");
			}
			//注册自定义的拦截器
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				// TODO Auto-generated method stub
				registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
				.excludePathPatterns("/index.html","/","/user/login","/myServlet");
			}
		};
		return adapter;
	}

	
}
