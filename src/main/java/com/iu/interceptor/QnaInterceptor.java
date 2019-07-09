package com.iu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.member.MemberDTO;

public class QnaInterceptor extends HandlerInterceptorAdapter {
	
	//컨트롤러 진입 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("member");
		boolean result = false;
		if(obj != null) {
			result = true;
		} else {
			response.sendRedirect("../member/memberLogin");
		}
		
		//return이 true면 다음 순서인 컨트롤러로 이동O
		//return이 false면 컨트롤러로 이동X
		return result;
	}

	//컨트롤러 진입 후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	//jsp를 렌더링 후
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
	
}