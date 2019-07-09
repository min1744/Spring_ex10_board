package com.iu.s10;

import java.io.File;
import java.util.Enumeration;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.board.notice.NoticeDTO;
import com.iu.board.notice.NoticeService;
import com.iu.util.FileSaver;
import com.iu.util.PageMaker;

@Controller
@RequestMapping(value = "/notice/")
public class NoticeController {
	@Inject
	private NoticeService noticeService;
	
	@ModelAttribute("test")
	public String set()throws Exception{
		return "Test";
	}
	
	@RequestMapping(value = "noticeDelete")
	public String setDelete(int num, Model model)throws Exception{
		int result = noticeService.setDelete(num);
		String message="Delete Fail";
		if(result>0) {
			message = "Delete Success";
		}
		model.addAttribute("message", message);
		model.addAttribute("path", "./noticeList");
		
		return "common/messageMove";
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public String setUpdate(NoticeDTO noticeDTO, Model model)throws Exception{
		int result = noticeService.setUpdate(noticeDTO);
		String view="common/messageMove";
		if(result>0) {
			view = "redirect:./noticeList";
		}else {
			model.addAttribute("message", "Update Fail");
			model.addAttribute("path", "./noticeList");
		}
		return view;
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public String setUpdate(int num, Model model)throws Exception{
		BoardDTO boardDTO = noticeService.getSelect(num);
		model.addAttribute("dto", boardDTO);
		model.addAttribute("board", "notice");
		return "board/boardUpdate";
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public String setWrite(NoticeDTO noticeDTO)throws Exception{
		System.out.println(noticeDTO.getContents());
		/*
		 * int result = noticeService.setWrite(noticeDTO, f1, session); String
		 * view="common/messageMove"; if(result>0) { view = "redirect:./noticeList";
		 * }else { model.addAttribute("message", "Write Fail");
		 * model.addAttribute("path", "./noticeList"); }
		 */
		return "";
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public String setWrite(Model model) throws Exception {
		model.addAttribute("board", "notice");
		return "board/boardWrite";
	}
	
	@RequestMapping(value = "noticeSelect", method = RequestMethod.GET)
	public String getSelect(Model model, @RequestParam(required = false, defaultValue = "0") int num)throws Exception{
		 BoardDTO boardDTO = noticeService.getSelect(num);
		 String view="common/messageMove";
		 if(boardDTO != null) {
			 view = "board/boardSelect";
			 model.addAttribute("board", "notice");
			 model.addAttribute("dto", boardDTO);
		 }else {
			 model.addAttribute("message", "No Contents");
			 model.addAttribute("path", "./noticeList");
		 }
		 
		 return view;
	}
	
	@RequestMapping(value = "noticeList", method = RequestMethod.GET)
	public ModelAndView getList(PageMaker pageMaker, ModelAndView mv)throws Exception{
		List<BoardDTO> ar = noticeService.getList(pageMaker);
		mv.addObject("list", ar);
		mv.addObject("pager", pageMaker);
		mv.addObject("board", "notice");
		
		mv.setViewName("board/boardList");
		
		return mv;
	}
}