package com.iu.s10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.mall.product.ProductService;
import com.iu.mall.product.ProductVO;

@Controller
@RequestMapping("/mall/")
public class ProductController {
	
	@Inject
	private ProductService productService;
	
	@ModelAttribute
	public ProductVO getProductVO() throws Exception{
		ProductVO productVO = new ProductVO();
		//productVO.setCategory("T");
		return productVO;
	}
	
	@ModelAttribute("list")
	public Map<String, String> getCategory() throws Exception{
		/*
		 * List<String> list = new ArrayList<String>(); list.add("사료"); list.add("미용");
		 * list.add("장난감");
		 */
		Map<String, String> map = new HashMap<String, String>();
		map.put("T", "장난감");
		map.put("F", "사료");
		map.put("B", "미용");
		
		return map;
	}
	
	@RequestMapping(value = "productAdd", method = RequestMethod.POST)
	public ModelAndView productWrite(ProductVO productVO, String [] options , List<MultipartFile> f1, HttpSession session, ModelAndView mv) throws Exception{
		//System.out.println(productVO.getCategory());
		//System.out.println(productVO.getTitle());
		//System.out.println(productVO.getMainContents());
		//System.out.println("oname : "+f1.get(0).getOriginalFilename());
		//System.out.println(productVO.getOptionsVO().getContents());
		//System.out.println("option[0] : "+options[0]);
		int result = productService.setWrite(productVO, f1, session);
		String message = "Add Fail";
		if(result > 0) {
			message = "Add Success";
		}
		mv.addObject("message", message);
		mv.addObject("path", "../");
		mv.setViewName("common/messageMove");
		
		return mv;
	}
	
	@RequestMapping(value = "productAdd", method = RequestMethod.GET)
	public void productWrite(String [] options) throws Exception{
		//ProductVO productVO = new ProductVO();
		//ModelAndView mv = new ModelAndView();
		//mv.addObject("productVO", productVO);
	}
}