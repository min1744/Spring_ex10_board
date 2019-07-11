package com.iu.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileSaver {

	// 1. Spring에서 제공하는 FileCopyUtils 클래스의 copy 메서드 사용
	// 1-1. 저장경로
	// 1-2. MultipartFile
	public String saveFile(String realPath, MultipartFile multipartFile) throws Exception{
		
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		// a. 저장할 파일명 생성
		//	- UUID 클래스 사용. (유니버셜 유니크 아이디)
		String fileSystemName = UUID.randomUUID().toString();	// 391dd00d-9142-4a19-a200-d192ab17e556 이런식으로
		String originalName = multipartFile.getOriginalFilename();	// 저장될 때 이름
		originalName = originalName.substring(originalName.lastIndexOf('.'));	// 확장자
		fileSystemName = fileSystemName + originalName;	// 이상한 이름 + .확장자
		System.out.println(fileSystemName);
		
		// 저장
		file = new File(realPath,fileSystemName);
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		
		return fileSystemName;	
	}
	
	// 2. OutPutStream 연결
	public String saveFile2(String realPath, MultipartFile multipartFile)throws Exception{
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		// a. 저장할 파일명 생성
		//	- UUID 클래스 사용. (유니버셜 유니크 아이디)
		String fileSystemName = UUID.randomUUID().toString();	// 391dd00d-9142-4a19-a200-d192ab17e556 이런식으로
		String originalName = multipartFile.getOriginalFilename();	// 저장될 때 이름
		originalName = originalName.substring(originalName.lastIndexOf('.'));	// 확장자
		fileSystemName = fileSystemName + originalName;	// 이상한 이름 + .확장자
		System.out.println(fileSystemName);
		
		// 저장
		file=new File(realPath, fileSystemName);
		FileOutputStream fs = new FileOutputStream(file);
		fs.write(multipartFile.getBytes());
		
		return fileSystemName;
	}
	
	// 3. MultipartFile 클래스의 transferTo 메서드 사용
	public String saveFile3(String realPath, MultipartFile multipartFile)throws Exception{
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		// a. 저장할 파일명 생성
		//	- UUID 클래스 사용. (유니버셜 유니크 아이디)
		String fileSystemName = UUID.randomUUID().toString();	// 391dd00d-9142-4a19-a200-d192ab17e556 이런식으로
		String originalName = multipartFile.getOriginalFilename();	// 저장될 때 이름
		originalName = originalName.substring(originalName.lastIndexOf('.'));	// 확장자
		fileSystemName = fileSystemName + originalName;	// 이상한 이름 + .확장자
		System.out.println(fileSystemName);
		
		// 저장
		file = new File(realPath, fileSystemName);
		multipartFile.transferTo(file);
		
		return fileSystemName;
	}
	
	public int deleteFile(String realPath, String fname)throws Exception{
		File file = new File(realPath, fname);
		boolean result=false;
		int check=0;
		if(file.exists()) {
			result=file.delete();
		}
		if(result) {
			check=1;
		}
		return check;
	}
	
}