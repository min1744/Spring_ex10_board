package com.iu.mall.product;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ThumbnailDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "ThumbnailMapper.";
	
	public int setWrite(ThumbnailVO thumbnailVO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setWrite", thumbnailVO);
	}
}