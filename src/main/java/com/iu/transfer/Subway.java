package com.iu.transfer;

import org.springframework.stereotype.Component;

@Component
public class Subway {
	
	public void free() {
		
	}
	
	public void subway() throws Exception {
		System.out.println("자리 양보...");
		System.out.println("옆 사람 핸드폰 보기...");
		throw new Exception();
	}
}