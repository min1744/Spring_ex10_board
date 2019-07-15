package com.iu.mall.cart;

public class CartVO {
	private int num;
	private String id;
	private String pid;
	private int options;
	private int amount;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getOptions() {
		return options;
	}
	public void setOptions(int options) {
		this.options = options;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}