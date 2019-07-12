package com.iu.mall.product;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class OptionsDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "OptionsMapper.";
	
	public int setWrite(OptionsVO optionsVO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setWrite", optionsVO);
	}
}