package com.iu.mall.cart;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.iu.member.MemberDTO;

@Service
public class CartService {
	
	@Inject
	private CartDAO cartDAO;
	
	public int setUpdate(CartVO cartVO) throws Exception{
		return cartDAO.setUpdate(cartVO);
	}
	
	public int setWrite(CartVO cartVO) throws Exception{
		return cartDAO.setWrite(cartVO);
	}
	
	public List<CartListVO> getList(HttpSession session) throws Exception{
		String id = ((MemberDTO)session.getAttribute("member")).getId();
		return cartDAO.getList(id);
	}
	
	public int setDelete(Integer [] nums) throws Exception{
		//List<Integer> list = Arrays.asList(nums);
		return cartDAO.setDelete(nums);
	}
}