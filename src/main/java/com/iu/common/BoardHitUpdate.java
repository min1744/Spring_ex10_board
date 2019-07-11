package com.iu.common;

import javax.inject.Inject;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.iu.board.BoardDTO;
import com.iu.board.qna.QnaDAO;

@Component
//@Aspect
public class BoardHitUpdate {
	
	@Inject
	private QnaDAO qnaDAO;
	
	//@Around("execution(* com.iu.board..*.*Service.getSelect(..))")
	public Object hitUpdate(ProceedingJoinPoint joinPoint) throws Exception{
		Object [] ar = joinPoint.getArgs();
		int num = (Integer)ar[0];
		Object obj = null;
		try {
			num = qnaDAO.hitUpdate(num);
			obj = joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}
}