package com.iu.board.productQna;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ProductQnaDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="ProductQnaMapper.";
	
	public int setWrite(ProductQnaVO productQnaVO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setWrite", productQnaVO);
	}
	
	public List<ProductQnaVO> getList(Map<String, Object> map) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", map);
	}
	
	public ProductQnaVO getSelect(int num) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getSelect", num);
	}
}