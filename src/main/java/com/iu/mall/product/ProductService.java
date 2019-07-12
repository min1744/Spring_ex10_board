package com.iu.mall.product;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.file.FileDTO;
import com.iu.util.FileSaver;
import com.iu.util.PageMaker;

@Service
public class ProductService {
	
	@Inject
	private ProductDAO productDAO;
	@Inject
	private OptionsDAO optionsDAO;
	@Inject
	private ThumbnailDAO thumbnailDAO;
	@Inject
	private FileSaver fileSaver;
	
	//list
	public List<ProductVO> getList(PageMaker pageMaker) throws Exception{
		pageMaker.setPerPage(9);
		pageMaker.makeRow();
		int totalCount = 0;
		pageMaker.makePage(totalCount);
		List<ProductVO> ar = productDAO.getList(pageMaker);
		
		return ar;
	}
	
	//write
	public int setWrite(ProductVO productVO, List<MultipartFile> f1, HttpSession session) throws Exception{
		//1. PID 생성
		//현재시간을 milliseconds로 변환,
		//F+현재 시간
		//T+현재 시간
		//B+현재 시간
		long time = System.currentTimeMillis();
		String pid = productVO.getCategory()+time;
		String realPath = session.getServletContext().getRealPath("/resources/mall");
		
		//2. product테이블에 insert
		productVO.setPid(pid);
		int result = productDAO.setWrite(productVO);
		/*
		 * if(result < 1) { throw new Exception(); }
		 */
		//3. options insert
		//4. file HDD Save
		for(MultipartFile multipartFile :f1) {
			if(multipartFile.getOriginalFilename().length() > 0) {
				ThumbnailVO thumbnailVO = new ThumbnailVO();
				thumbnailVO.setPid(pid);
				thumbnailVO.setOname(multipartFile.getOriginalFilename());
				thumbnailVO.setFname(fileSaver.saveFile(realPath, multipartFile));
				//5. thumbnail insert
				result = thumbnailDAO.setWrite(thumbnailVO);
			}
		}
		
		return result;
	}
}