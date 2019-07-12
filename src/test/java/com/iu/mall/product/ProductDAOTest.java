package com.iu.mall.product;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s10.AbstractTest;
import com.iu.util.PageMaker;

public class ProductDAOTest extends AbstractTest {

	@Inject
	private ProductDAO productDAO;
	
	@Test
	public void test() throws Exception {
		PageMaker pageMaker = new PageMaker();
		pageMaker.makeRow();
		List<ProductVO> ar = productDAO.getList(pageMaker);
		System.out.println(ar.size());
		System.out.println(ar.get(0).getNailVOs().size());
	}
}