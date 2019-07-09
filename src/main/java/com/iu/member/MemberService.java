package com.iu.member;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.file.MemberFileDAO;
import com.iu.file.MemberFileDTO;
import com.iu.util.FileSaver;

@Service
public class MemberService {
	@Inject
	private MemberDAO memberDAO;
	@Inject
	private FileSaver fileSaver;
	@Inject
	private MemberFileDAO memberFileDAO;
	
	public int setWrite(MemberDTO memberDTO, MultipartFile photo, HttpSession session)throws Exception{
		//1.저장 경로
		String realPath = session.getServletContext().getRealPath("/resources/member");
		System.out.println(realPath);
		String fname = fileSaver.saveFile(realPath, photo);
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId(memberDTO.getId());
		memberFileDTO.setFname(fname);
		memberFileDTO.setOname(photo.getOriginalFilename());
		int result = memberDAO.setWrite(memberDTO);
		result = memberFileDAO.setWrite(memberFileDTO);
		
		return result;
	}
	
	public MemberDTO getSelect(MemberDTO memberDTO)throws Exception{
		return memberDAO.getSelect(memberDTO);
	}
	

}
