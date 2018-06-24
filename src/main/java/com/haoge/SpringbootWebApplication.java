package com.haoge;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

@SpringBootApplication
public class SpringbootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebApplication.class, args);
	}
	@Bean
	public ViewResolver myViewResolver() {
		return new myViewResolver();
	}
	
	public static class myViewResolver implements ViewResolver{

		@Override
		public View resolveViewName(String arg0, Locale arg1) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
