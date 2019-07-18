package com.iu.s10;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//예외객체만 전문적으로 처리하는 Controller
@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView getNull() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/error404");
		
		return mv;
	}
	
	@ExceptionHandler(SQLException.class)
	public void getSql() {
		
	}
	
	@ExceptionHandler(Exception.class)
	public void getEx() {
		
	}
	
	//예외발생의 최상위
	@ExceptionHandler(Throwable.class)
	public void getAll() {
		
	}
}