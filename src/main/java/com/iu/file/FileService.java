package com.iu.file;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.iu.util.FileSaver;

@Service
public class FileService {

	@Inject
	private FileDAO fileDAO;
	@Inject
	private FileSaver fileSaver;
	
	public int setDelete(FileDTO fileDTO, String board, HttpSession session)throws Exception{
		int result = fileDAO.setDelete(fileDTO.getFnum());
		
		if(result>0) {
			String realPath = session.getServletContext().getRealPath("/resources/"+board);
			result = fileSaver.deleteFile(realPath, fileDTO.getFname());
		}
		return result;
	}
}