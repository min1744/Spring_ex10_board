package com.iu.member;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.util.PageMaker;

@Repository
public class MemberDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="MemberMapper.";
	
	public int setDelete(List<String> list) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", list);
	}
	
	public List<MemberDTO> getList(PageMaker pageMaker) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", pageMaker);
	}
	
	public int getTotalCount(PageMaker pageMaker) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotalCount", pageMaker);
	}
	
	public int setWrite(MemberDTO memberDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setWrite", memberDTO);
	}
	
	public MemberDTO getSelect(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getSelect", memberDTO);
	}
}