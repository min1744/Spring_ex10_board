package com.iu.validator;

import java.util.regex.Pattern;

import javax.inject.Inject;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.iu.member.MemberDAO;
import com.iu.member.MemberDTO;

public class MemberDTOValidate implements Validator {

	@Inject
	private MemberDAO memberDAO;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return MemberDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberDTO memberDTO = (MemberDTO)target;
		String ex1 = "[a-z]+";
		String ex2 = "[A-Z]+";
		String ex3 = "\\d+";
		String ex4 = "\\W+";
		String ex5 = "{10,15}";
		String id = memberDTO.getId();
		String pw = memberDTO.getPw();
		boolean check1 = Pattern.matches(ex1, id);
		boolean check2 = Pattern.matches(ex2, id);
		boolean check3 = Pattern.matches(ex3, id);
		boolean check4 = Pattern.matches(ex4, id);
		boolean check5 = Pattern.matches(ex5, id);
		System.out.println("소문자 : "+check1);
		System.out.println("대문자 : "+check2);
		System.out.println("숫자 : "+check3);
		System.out.println("특수문자 : "+check4);
		System.out.println("10~15자리 : "+check5);
		System.out.println("==========");
		
		//id
		if(id == null || id.length() == 0) {
			//errors.rejectValue("멤버변수명", "properties key");
			errors.rejectValue("id", "member.id");
		} else {
			try {
				MemberDTO checkId = memberDAO.getId(memberDTO);
				if(checkId != null) {
					errors.rejectValue("id", "member.id.duplicate");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//pw
		if(pw == null || pw.length() == 0) {
			errors.rejectValue("pw", "member.pw");
		} else {
			if(!memberDTO.getPw().equals(memberDTO.getPw2())) {
				errors.rejectValue("pw2", "member.pw.equal");
			}
		}
		//name
		if(memberDTO.getName() == null || memberDTO.getName().length() == 0) {
			errors.rejectValue("name", "member.name");
		}
		//email
		if(memberDTO.getEmail() == null || memberDTO.getEmail().length() == 0) {
			errors.rejectValue("email", "member.email");
		}
	}
}