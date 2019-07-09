package com.iu.board.notice;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.file.FileDAO;
import com.iu.file.FileDTO;
import com.iu.util.FileSaver;
import com.iu.util.PageMaker;

@Service
public class NoticeService implements BoardService {
	
	@Inject
	private NoticeDAO noticeDAO;
	@Inject
	private FileSaver fileSaver;
	@Inject
	private FileDAO fileDAO;

	@Override
	public int setWrite(BoardDTO boardDTO, List<MultipartFile> multipartFiles, HttpSession session) throws Exception {
		int result = noticeDAO.setWrite(boardDTO);
		
		
			
			ArrayList<FileDTO> files = new ArrayList<FileDTO>();
			String realPath = session.getServletContext().getRealPath("/resources/upload");
			System.out.println(realPath);
			for(MultipartFile multipartFile:multipartFiles) {
				System.out.println(multipartFile.getOriginalFilename().length());
				if(multipartFile.getOriginalFilename().length()>0 ) {
				String fname = fileSaver.saveFile(realPath, multipartFile);
				FileDTO fileDTO = new FileDTO();
				fileDTO.setNum(boardDTO.getNum());
				fileDTO.setFname(fname);
				fileDTO.setOname(multipartFile.getOriginalFilename());
				//fileDAO.setWrite(fileDTO);
				files.add(fileDTO);
				}
			}
			
			if(files.size()>0) {
				fileDAO.setWrite(files);
			}
		
		
		//파일을 HDD에 저장
		//notice 테이블에 저장
		//num
		//files 테이블에 저장
		
		return result;
	}

	//@Override
	public int setDelete(int num) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(num);
	}

	//@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getSelect(num);
	}

	@Override
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception {
		pageMaker.makeRow();
		int totalCount = noticeDAO.getTotalCount(pageMaker);
		//페이징 처리 계산
		pageMaker.makePage(totalCount);
		
		return noticeDAO.getList(pageMaker);
	}

	@Override
	public int setDelete(int num, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO, List<MultipartFile> f1, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
