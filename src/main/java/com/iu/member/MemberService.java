package com.iu.member;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.file.MemberFileDAO;
import com.iu.file.MemberFileDTO;
import com.iu.util.FileSaver;
import com.iu.util.PageMaker;

@Service
public class MemberService {
	@Inject
	private MemberDAO memberDAO;
	@Inject
	private FileSaver fileSaver;
	@Inject
	private MemberFileDAO memberFileDAO;
	
	//deleteAll
	public int setDelete(String [] id) throws Exception{
		List<String> list = Arrays.asList(id);
		return memberDAO.setDelete(list);
	}
	
	public List<MemberDTO> getList(PageMaker pageMaker) throws Exception{
		pageMaker.makeRow();
		pageMaker.makePage(memberDAO.getTotalCount(pageMaker));
		
		return memberDAO.getList(pageMaker);
	}
	
	public int setWrite(MemberDTO memberDTO, MultipartFile photo, HttpSession session)throws Exception{
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
	
	public int setDelete(List<String> list) throws Exception{
		return memberDAO.setDelete(list);
	}
}