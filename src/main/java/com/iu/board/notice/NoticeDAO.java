package com.iu.board.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.util.PageMaker;


@Repository
public class NoticeDAO implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="NoticeMapper.";

	
	
	@Override
	public int setWrite(BoardDTO boardDTO) throws Exception {
				
		int result = sqlSession.insert(NAMESPACE+"noticeWrite", boardDTO);
		
		return result;
	}

	@Override
	public int setDelete(int num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE+"noticeDelete", num);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"noticeUpdate", boardDTO);
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"noticeSelect", num);
	}

	@Override
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"noticeList", pageMaker);
	}

	@Override
	public int getTotalCount(PageMaker pageMaker) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"totalCount", pageMaker);
	}
	
	
	
}
