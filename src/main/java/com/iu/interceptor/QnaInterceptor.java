package com.iu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.member.MemberDTO;

public class QnaInterceptor extends HandlerInterceptorAdapter {
	
	//��Ʈ�ѷ� ���� ��
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
		
		//return�� true�� ���� ������ ��Ʈ�ѷ��� �̵�
		//return�� false�� ��Ʈ�ѷ��� �̵�X
		return result;
	}

	//��Ʈ�ѷ� ���� ��
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	//jsp ������ ��
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
	
}