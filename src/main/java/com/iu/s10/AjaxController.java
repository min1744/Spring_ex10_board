package com.iu.s10;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.file.FileDTO;
import com.iu.file.FileService;

@Controller
public class AjaxController {
	@Inject
	private FileService fileService;
	
	@RequestMapping(value = "/ajax/summerFileDelete", method = RequestMethod.POST)
	public ModelAndView summerFileDelete(String fileName, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = fileService.summernoteFileDelete(fileName, session);
		mv.addObject("result", result);
		mv.setViewName("common/message");
		
		return mv;
	}
	
	@RequestMapping(value ="/ajax/summerFileUpload", method = RequestMethod.POST)
	   public ModelAndView summerFileUplad(MultipartFile file,HttpSession session) throws Exception{
	      String fileName = session.getServletContext().getContextPath();//route 이름
	      fileName = fileName + File.separator + "resources" + File.separator + "summernote" + File.separator;
	      //fileName = fileName+"/resources/summernote/";
	      fileName = fileName + fileService.summernoteFileUpload(file, session);
	      ModelAndView mv = new ModelAndView();
	      mv.addObject("result",fileName);
	      mv.setViewName("common/message");
	      
	      return mv;
	   }
	
	@RequestMapping(value = "/ajax/fileDownload", method = RequestMethod.POST)
	public ModelAndView fileDownload(FileDTO fileDTO, String board) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("file", fileDTO);
		mv.addObject("board", board);
		mv.setViewName("fileDown");
		
		return mv;
	}
	
	@RequestMapping(value = "/ajax/fileDelete", method = RequestMethod.POST)
	public ModelAndView fileDelete(FileDTO fileDTO, String board, HttpSession session)throws Exception{
		
		ModelAndView mv = new ModelAndView();
		int result = fileService.setDelete(fileDTO, board, session);
		mv.addObject("result", result);
		mv.setViewName("common/message");
		return mv;
	}
}