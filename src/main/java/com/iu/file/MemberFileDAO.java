package com.iu.file;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.member.MemberDTO;

@Repository
public class MemberFileDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="MemberFileMapper.";
	
	public int setWrite(MemberFileDTO memberFileDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setWrite", memberFileDTO);
	}
	
	public MemberFileDTO getSelect(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getSelect", memberDTO);
	}

}
