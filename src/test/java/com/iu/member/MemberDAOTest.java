package com.iu.member;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s10.AbstractTest;

public class MemberDAOTest extends AbstractTest{

	@Inject
	private MemberDAO memberDAO;
	@Test
	public void deleteTest() throws Exception{
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		int result = memberDAO.setDelete(list);
		assertEquals(1, result);
	}
}