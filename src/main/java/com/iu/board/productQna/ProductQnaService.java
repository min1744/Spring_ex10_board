package com.iu.board.productQna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.iu.util.PageMaker;

@Service
public class ProductQnaService {

	@Inject
	private ProductQnaDAO productQnaDAO;

	public int setWrite(ProductQnaVO productQnaVO) throws Exception{
		return productQnaDAO.setWrite(productQnaVO);
	}

	public ProductQnaVO getSelect(int num) throws Exception{
		return productQnaDAO.getSelect(num);
	}

	public List<ProductQnaVO> getList(PageMaker pageMaker, String pid) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pid", pid);
		map.put("pager", pageMaker);

		return productQnaDAO.getList(map);
	}
}