package com.iu.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.iu.board.BoardDTO;

public class QnaDTOValidate implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return BoardDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		BoardDTO boardDTO = (BoardDTO)target;
		//title 검증
		if(boardDTO.getTitle()== null || boardDTO.getTitle().length()==0) {
			errors.rejectValue("title", "title.require");
		}
		
		//writer 검증
		if(boardDTO.getWriter()== null || boardDTO.getWriter().length()==0) {
			errors.rejectValue("writer", "writer.require");
		}
		
		//contents 검증
		if(boardDTO.getContents()== null || boardDTO.getContents().length()==0) {
			errors.rejectValue("contents", "require");
		}	
	}
}