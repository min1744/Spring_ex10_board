package com.iu.s10;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.board.BoardDTO;
import com.iu.board.qna.QnaDTO;
import com.iu.board.qna.QnaService;
import com.iu.util.PageMaker;

@Controller
@RequestMapping(value = "/qna/")
public class QnaController {
	
	@Inject
	private QnaService qnaService;
	
	//model.addAttribute("board","qna") 
	@ModelAttribute("board")
	public String board() {
		return "qna";
	}
	
	
	@RequestMapping(value = "qnaDelete", method = RequestMethod.GET)
	public String setDelete(int num, HttpSession session)throws Exception{
		int result = qnaService.setDelete(num, session);
		return "redirect:./qnaList";
	}
	
	//reply
	@RequestMapping(value = "qnaReply", method = RequestMethod.POST)
	public ModelAndView setReply(BoardDTO qnaDTO, RedirectAttributes rd)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setReply(qnaDTO);
		String message="Reply False";
		if(result>0) {
			message="Reply Success";
		}
		rd.addFlashAttribute("message",message);
		
		mv.setViewName("redirect:./qnaList");
		return mv;
	}
	//reply form
	@RequestMapping(value = "qnaReply", method = RequestMethod.GET)
	public ModelAndView setReply(int num)throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("num", num);
		//mv.addObject("board", "qna");
		mv.setViewName("board/boardReply");
		return mv;
	}
	
	//update 
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.POST)
	public ModelAndView setUpdate(BoardDTO qnaDTO, List<MultipartFile> f1, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setUpdate(qnaDTO, f1, session);
		mv.setViewName("redirect:./qnaList");
		return mv;
	}
	
	//update form
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.GET)
	public ModelAndView setUpdate(int num)throws Exception{
		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO = qnaService.getSelect(num);
		QnaDTO qnaDTO = (QnaDTO)boardDTO;
		System.out.println("Board Size : "+qnaDTO.getFiles().size());
		mv.addObject("dto", boardDTO);
		//mv.addObject("board", "qna");
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	
	
	//write
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public ModelAndView setWrite(BoardDTO qnaDTO, List<MultipartFile> f1, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setWrite(qnaDTO, f1, session);
		
		if(result>0) {
			mv.setViewName("redirect:./qnaList");
		}else {
			mv.addObject("message", "Write Fail");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/messageMove");
		}
		return mv;
	}

	//write
	@RequestMapping(value = "qnaWrite", method = RequestMethod.GET)
	public String setWrite()throws Exception{
		//model.addAttribute("board", "qna");
		return "board/boardWrite";
	}
	
	//select
	@RequestMapping(value = "qnaSelect", method = RequestMethod.GET)
	public ModelAndView getSelect(int num)throws Exception{
		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO = qnaService.getSelect(num);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	//list
	@RequestMapping(value = "qnaList", method = RequestMethod.GET)
	public ModelAndView getList(PageMaker pageMaker)throws Exception{
		
		List<BoardDTO> lists = qnaService.getList(pageMaker);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", lists);
		//mv.addObject("board", "qna");
		mv.addObject("pager", pageMaker);
		mv.setViewName("board/boardList");
		return mv;
	}
}