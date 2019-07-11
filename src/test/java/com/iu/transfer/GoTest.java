package com.iu.transfer;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.board.BoardDTO;
import com.iu.s10.AbstractTest;

public class GoTest extends AbstractTest{

	@Inject
	private Bus bus;
	@Autowired
	private Subway subway;
	
	@Test
	public void test() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(235);
		boardDTO.setWriter("iu");
		bus.bus2(boardDTO);
		
		//subway.free();
		
		//subway.subway();
		
	}
}