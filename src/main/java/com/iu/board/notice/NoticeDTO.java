package com.iu.board.notice;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.iu.board.BoardDTO;
import com.iu.file.FileDTO;

public class NoticeDTO extends BoardDTO {
	
	private List<FileDTO> files;

	public List<FileDTO> getFiles() {
		return files;
	}

	public void setFiles(List<FileDTO> files) {
		this.files = files;
	}
	
	

}
