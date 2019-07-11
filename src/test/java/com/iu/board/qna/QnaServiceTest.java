package com.iu.board.qna;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s10.AbstractTest;

public class QnaServiceTest extends AbstractTest {

	@Inject
	private QnaService qnaService;
	
	@Test
	public void test() throws Exception {
		qnaService.getSelect(4);
	}
}