package com.iu.file;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class FileDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="FileMapper.";
	
	public int setWrite(List<FileDTO> files) throws Exception{
		for(FileDTO f:files) {
			System.out.println(f.getNum());
			System.out.println(f.getFname());
			System.out.println(f.getOname());
		}
		int res = sqlSession.insert(NAMESPACE+"setWrite",files);
		return res;
	}
	
	public int setUpdate(FileDTO fileDTO) throws Exception{
		int res = sqlSession.update(NAMESPACE+"setUpdate", fileDTO);
		return res;
	}
	
	public int setDeleteAll(int num)throws Exception{
		return sqlSession.delete(NAMESPACE+"setDeleteAll", num);
	}
	
	public int setDelete(int fnum) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", fnum);
	}
	
	public FileDTO getSelect(int fnum) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getSelect", fnum);
	}
	
	public List<FileDTO> getList(int num) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", num);
	}
	
}
