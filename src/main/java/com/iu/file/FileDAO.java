package com.iu.file;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class FileDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "FileMapper.";
	
	public int setWrite(List<FileDTO> files) throws Exception{
		return sqlSession.insert(NAMESPACE+"setWrite", files);
	}
	
	public int setUpdate(FileDTO fileDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", fileDTO);
	}
	
	public int setDelete(int fnum) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", fnum);
	}
	
	public FileDTO getSelect(int fnum) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getSelect", fnum);
	}
	
	public List<FileDTO> getList(int num) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", num);
	}
}