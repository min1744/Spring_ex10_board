package com.iu.file;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.util.FileSaver;

@Service
public class FileService {

	@Inject
	private FileDAO fileDAO;
	@Inject
	private FileSaver fileSaver;
	
	public int summernoteFileDelete(String fileName, HttpSession session) throws Exception{
		String realPath = session.getServletContext().getRealPath("/resources/summernote");
		fileName = fileName.substring(fileName.lastIndexOf(File.separator));
		System.out.println(realPath);
		System.out.println(fileName);
		int result = fileSaver.deleteFile(realPath, fileName);
		
		return result;
	}
	
	public String summernoteFileUpload(MultipartFile file, HttpSession session) throws Exception{
		String realPath = session.getServletContext().getRealPath("/resources/summernote");
		String fname = fileSaver.saveFile(realPath, file);
		
		return fname;
	}
	
	public int setDelete(FileDTO fileDTO, String board, HttpSession session)throws Exception{
		int result = fileDAO.setDelete(fileDTO.getFnum());
		
		if(result>0) {
			String realPath = session.getServletContext().getRealPath("/resources/"+board);
			result = fileSaver.deleteFile(realPath, fileDTO.getFname());
		}
		return result;
	}
}