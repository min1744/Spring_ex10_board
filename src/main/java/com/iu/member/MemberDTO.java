package com.iu.member;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.iu.file.MemberFileDTO;

public class MemberDTO {
	
	//ex)	Size.memberDTO.id
	//		NotNull.memberDTO.pw
	@NotNull
	@Size(min = 6, max = 15)
	private String id;
	@NotNull
	@Size(min = 6, max = 12)
	private String pw;
	@Size(min = 6, max = 12)
	private String pw2;
	private String name;
	private String email;
	private int grade;
	private MemberFileDTO memberFileDTO;
	
	public String getPw2() {
		return pw2;
	}
	public void setPw2(String pw2) {
		this.pw2 = pw2;
	}
	public MemberFileDTO getMemberFileDTO() {
		return memberFileDTO;
	}
	public void setMemberFileDTO(MemberFileDTO memberFileDTO) {
		this.memberFileDTO = memberFileDTO;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	

}
