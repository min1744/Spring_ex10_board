package com.iu.board.qna;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.util.PageMaker;

@Repository
public class QnaDAO implements BoardDAO{
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="QnaMapper.";
	
	//답글 사전작업
	public int setReplyUpdate(BoardDTO qnaDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setReplyUpdate", qnaDTO);
	}
	
	//답글 달기
	public int setReply(BoardDTO qnaDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setReply", qnaDTO);
	}

	@Override
	public int getTotalCount(PageMaker pageMaker) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getCount", pageMaker);
	}

	@Override
	public int setWrite(BoardDTO boardDTO) throws Exception {
		System.out.println(boardDTO.getNum());
		return sqlSession.insert(NAMESPACE+"setWrite", boardDTO);
	}

	@Override
	public int setDelete(int num) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", num);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getSelect",num);
	}

	@Override
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", pageMaker);
	}

	
}
