package com.iu.s10;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iu.mall.cart.CartListVO;
import com.iu.mall.cart.CartService;
import com.iu.mall.cart.CartVO;

@Controller
@RequestMapping("/cart/")
public class CartController {

	@Inject
	private CartService cartService;
	
	@RequestMapping(value = "cartDelete", method = RequestMethod.POST)
	public int cartDelete(int [] num) throws Exception{
		
	}
	
	@RequestMapping(value = "cartUpdate", method = RequestMethod.POST)
	@ResponseBody
	public int cartUpdate(CartVO cartVO) throws Exception{
		
		return cartService.setUpdate(cartVO);
	}
	
	@RequestMapping(value = "cartList", method = RequestMethod.GET)
	public ModelAndView cartList(HttpSession session, ModelAndView mv) throws Exception{
		List<CartListVO> list = cartService.getList(session);
		mv.addObject("cartList", list);
		mv.setViewName("mall/cartList");
		
		return mv;
	}
	
	@RequestMapping(value = "cartWrite", method = RequestMethod.POST)
	@ResponseBody//리턴하는 데이터가 view의 경로가 아니라 데이터로 담아서 클라이언트로 전달
	public int cartWrite(CartVO cartVO) throws Exception{
		
		return cartService.setWrite(cartVO);
	}
}