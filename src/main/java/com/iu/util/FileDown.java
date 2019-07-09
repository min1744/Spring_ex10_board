package com.iu.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.file.FileDTO;

@Component
public class FileDown extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		FileDTO fileDTO = (FileDTO)model.get("file");
		String board = (String)model.get("board");
		String realPath = request.getSession().getServletContext().getRealPath("/resources/"+board);
		File file = new File(realPath, fileDTO.getFname());
		//한글처리
		response.setCharacterEncoding("UTF-8");//여기서 사용하는 인코딩 타입을 받아옴
		//파일의 크기
		response.setContentLength((int)file.length());
		//다운로드 시 파일 이름 인코딩 처리
		String fileName = URLEncoder.encode(fileDTO.getOname(), "UTF-8");//UTF-8 또는 getContentType()
		//header 설정
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		FileInputStream fi = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		FileCopyUtils.copy(fi, os);
		
		os.close();
		fi.close();
	}
}