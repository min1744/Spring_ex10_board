package com.iu.mall.product;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.util.PageMaker;

@Repository
public class ProductDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "ProductMapper.";
	
	public List<ProductVO> getList(PageMaker pageMaker) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", pageMaker);
	}
	
	public int setWrite(ProductVO productVO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setWrite", productVO);
	}
}