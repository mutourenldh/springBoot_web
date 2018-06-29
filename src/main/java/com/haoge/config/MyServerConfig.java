package com.haoge.config;

import java.util.Arrays;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.haoge.filter.MyFilter;
import com.haoge.listener.MyListener;
import com.haoge.servlet.MyServlet;

@Configuration
public class MyServerConfig {

	// 配置自定义的嵌入式的servlet容器
	@Bean
	public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {

			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				container.setPort(8083);
				// TODO Auto-generated method stub
			}
		};
	}

	// 注册自定义的servlet
	@Bean
	public ServletRegistrationBean myServletRegistra() {
		ServletRegistrationBean bean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
		bean.setLoadOnStartup(1);
		return bean;

	}

	// 注册自定义的filter
	@Bean
	public FilterRegistrationBean myFilterRegistra() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new MyFilter());
		registrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
		return registrationBean;

	}
	// 注册自定义的监听器
	@Bean
	public ServletListenerRegistrationBean myListener() {
		ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(
				new MyListener());
		return registrationBean;
	}

}
