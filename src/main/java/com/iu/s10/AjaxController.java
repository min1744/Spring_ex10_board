package com.iu.s10;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.file.FileDTO;
import com.iu.file.FileService;

@Controller
public class AjaxController {
	
	@Inject
	private FileService fileService;
	
	@RequestMapping(value = "/ajax/fileDelete", method = RequestMethod.POST)
	public ModelAndView fileDelete(FileDTO fileDTO, String board, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = fileService.setDelete(fileDTO, board, session);
		mv.addObject("result", result);
		mv.setViewName("common/message");
		
		return mv;
	}
}