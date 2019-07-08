package com.iu.board.qna;

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
public class QnaService implements BoardService {

	@Inject//or @Autowired
	private QnaDAO qnaDAO;
	@Inject
	private FileDAO fileDAO;
	@Inject//Inject 안 하고 객체 만들어서 사용해도 상관 없음
	private FileSaver fileSaver;

	//reply
	public int setReply(QnaDTO qnaDTO) throws Exception{
		//1. 사전작업
		int result = qnaDAO.setReplyUpdate(qnaDTO);
		//2. insert
		result = qnaDAO.setReply(qnaDTO);

		return result;
	}

	@Override
	public int setWrite(BoardDTO boardDTO, List<MultipartFile> multipartFiles, HttpSession session) throws Exception {
		// qna Insert
		int result = qnaDAO.setWrite(boardDTO);

		// files Insert
		String realPath=session.getServletContext().getRealPath("/resources/qna");
		// num = boardDTO.getNum();
		// oname = multipartFile.getOriginalName();
		// fname = fileSaver.saveFile(realPath, multipartFile);
		System.out.println("realPath : "+realPath);
		ArrayList<FileDTO> files = new ArrayList<FileDTO>();

		for(MultipartFile multipartFile : multipartFiles) {
			// 폼에서 파일첨부 안했을 때 에러 방지
			if(multipartFile.getOriginalFilename().length()>0) {
				FileDTO fileDTO = new FileDTO();
				fileDTO.setNum(boardDTO.getNum());
				fileDTO.setOname(multipartFile.getOriginalFilename());
				String fname = fileSaver.saveFile(realPath, multipartFile);
				fileDTO.setFname(fname);
				files.add(fileDTO);
			}
		}

		if(files.size() > 0) {
			result = fileDAO.setWrite(files);
		}

		return result;
	}

	@Override
	public int setDelete(int num) throws Exception {
		return qnaDAO.setDelete(num);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO, List<MultipartFile> f1, HttpSession session) throws Exception {
		int result = qnaDAO.setUpdate(boardDTO);
		String realPath = session.getServletContext().getRealPath("/resources/qna");
		ArrayList<FileDTO> files = new ArrayList<FileDTO>();
		for(MultipartFile multipartFile:f1) {
			if(multipartFile.getOriginalFilename().length() > 0) {
				FileDTO fileDTO = new FileDTO();
				fileDTO.setNum(boardDTO.getNum());
				fileDTO.setOname(multipartFile.getOriginalFilename());
				fileDTO.setFname(fileSaver.saveFile(realPath, multipartFile));
				files.add(fileDTO);
			}
		}
		if(files.size() > 0) {
			result = fileDAO.setWrite(files);
		}
		
		return result;
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		BoardDTO boardDTO = qnaDAO.getSelect(num);
		QnaDTO qnaDTO = (QnaDTO)boardDTO;
		if(qnaDTO.getFiles().size()==1) {
			if(qnaDTO.getFiles().get(0).getFname()==null) {
				qnaDTO.setFiles(new ArrayList<FileDTO>());
			}
		}
		return boardDTO;
	}

	@Override
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception {
		//1. startRow, lastRow
		pageMaker.makeRow();
		List<BoardDTO> list = qnaDAO.getList(pageMaker);
		//2. paging, totalCount
		pageMaker.makePage(qnaDAO.getTotalCount(pageMaker));

		return list;
	}
}