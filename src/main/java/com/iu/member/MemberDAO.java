package com.iu.member;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="MemberMapper.";
	
	public int setWrite(MemberDTO memberDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setWrite", memberDTO);
	}
	
	public MemberDTO getSelect(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getSelect", memberDTO);
	}

}
