package com.haoge.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 编写自定义的登录拦截器
 * @author LDH
 *
 */
public class LoginHandlerInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	//登录之前进行检查
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		Object user = request.getSession().getAttribute("loginUser");
		if (user==null) {//未进行登录，返回登录页面
			request.setAttribute("msg", "请先进行登录");
			request.getRequestDispatcher("/index.html").forward(request, response); 
			return false;

		}else {
			//登录成功，放行
			return true;
		}
	}

}
