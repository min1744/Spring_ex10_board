package com.iu.transfer;

import java.util.List;

import javax.inject.Inject;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.iu.board.BoardDTO;
import com.iu.board.qna.QnaDAO;

@Component
@Aspect
public class CardCheck {
	
	@Inject
	private QnaDAO qnaDAO;

	//@Before("execution(* com.iu.transfer.Bus.bus()) || execution(* com.iu.transfer.Subway.subway())")
	public void cardIn() {
		System.out.println("삑! 학생입니다.");
	}
	
	//@AfterReturning("execution(* com.iu.transfer.Bus.bus())")
	public void cardOut() {
		System.out.println("삑! 안녕히 가세요...");
	}
	
	@Around("execution(* com.iu.transfer.Bus.bus2(..))")
	public Object check(ProceedingJoinPoint joinPoint) {
		//pointcut 상속(매개변수 joinPoint)
		System.out.println("Card check In");
		
		Object [] ar = joinPoint.getArgs();
		BoardDTO boardDTO = (BoardDTO)ar[0];
		
		try {
			boardDTO = qnaDAO.getSelect(boardDTO.getNum());
			System.out.println("t"+boardDTO.getTitle());
			System.out.println("w : "+boardDTO.getWriter());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(boardDTO.getNum());
		System.out.println(boardDTO.getWriter());
		
		Object obj = null;
		try {
			obj = joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Card check Out");
		
		return obj;
	}
}