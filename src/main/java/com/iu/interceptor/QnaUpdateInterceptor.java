package com.iu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.board.BoardDTO;
import com.iu.member.MemberDTO;

public class QnaUpdateInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		String id = ((MemberDTO)session.getAttribute("member")).getId();
		String writer = ((BoardDTO)modelAndView.getModel().get("dto")).getWriter();
		System.out.println("id : "+id);
		System.out.println("writer : "+writer);
		if(id.equals(writer)) {
			modelAndView.setViewName("board/boardUpdate");
		} else {
			modelAndView.addObject("message", "Access Fail");
			modelAndView.addObject("path", "../member/memberLogin");
			modelAndView.setViewName("common/messageMove");
		}
	}
}