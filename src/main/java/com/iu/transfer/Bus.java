package com.iu.transfer;

import org.springframework.stereotype.Component;

import com.iu.board.BoardDTO;

@Component
public class Bus {
	
	public void bus2(BoardDTO boardDTO) {
		System.out.println("Bus2 Process");
	}
	
	public void bus() {
		System.out.println("창 밖을 보고...");
		System.out.println("속으로 욕하고...");
	}
}