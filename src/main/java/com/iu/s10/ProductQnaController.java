package com.iu.s10;

import java.util.List;

import javax.inject.Inject;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iu.board.productQna.ProductQnaService;
import com.iu.board.productQna.ProductQnaVO;
import com.iu.util.PageMaker;

@RestController//모든 메서드들에 @ResponseBody를 추가시켜주는 controller
@RequestMapping("/productQna/")
public class ProductQnaController {
	
	@Inject
	private ProductQnaService productQnaService;
	
	@RequestMapping(value = "productQnaList/{id}", method = RequestMethod.GET)
	//@ResponseBody
	public List<ProductQnaVO> getList(PageMaker pageMaker, @PathVariable(value = "id") String pid) throws Exception{
		return productQnaService.getList(pageMaker, pid);
		/*
		 * JSONArray ar = new JSONArray(); for(ProductQnaVO productQnaVO:list) {
		 * JSONObject js = new JSONObject();//{} js.put("writer",
		 * productQnaVO.getWriter());//{"writer":""} js.put("contents",
		 * productQnaVO.getContents());//{"writer":"", "contents":""} ar.add(js); }
		 */
		
		//return ar.toString();
	}
	
	@RequestMapping(value = "productQnaSelect", method = RequestMethod.GET)
	//@ResponseBody
	public ProductQnaVO getSelect(int num) throws Exception{
		return productQnaService.getSelect(num);
		/*
		 * JSONObject js = new JSONObject();//{} js.put("writer",
		 * productQnaVO.getWriter());//{"writer":""} js.put("contents",
		 * productQnaVO.getContents());//{"writer":"", "contents":""} return
		 * js.toJSONString();//문자열로 바꾸기
		 */		//productQnaVO.getTitle();
	}
	
	@RequestMapping(value = "productQnaWrite", method = RequestMethod.POST)
	//@ResponseBody
	public int setWrite(ProductQnaVO productQnaVO) throws Exception{
		//writer
		//title
		//contents
		//pid
		//{"writer":productQnaVO.getWriter()}
		//String result = "{\"writer\"\""+productQnaVO.getWriter()+"\",";
		return productQnaService.setWrite(productQnaVO);
	}
}