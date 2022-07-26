package com.leer.mypage.model.vo;

import java.sql.Date;

public class Cart {
	
	private int cartNo;
	private int memNo;
	private String pCode;
	private String imageUrl;
	private int amount;
	private int orCycle;
	private Date cartDate;
	private String pName;
	private int price;
	private int deliFee;
	private int point;
	
	
	
	public Cart() {}
	
	
	public Cart(int memNo, String pCode, int amount, int orCycle, Date cartDate) {
		super();
		this.memNo = memNo;
		this.pCode = pCode;
		this.amount = amount;
		this.orCycle = orCycle;
		this.cartDate = cartDate;
	}


	public Cart( int cartNo, int memNo, String pCode, String imageUrl, int amount, int orCycle, Date cartDate, String pName, int price, int deliFee, int point) {
		super();
		this.cartNo = cartNo;
		this.memNo = memNo;
		this.pCode = pCode;
		this.imageUrl = imageUrl;
		this.amount = amount;
		this.orCycle = orCycle;
		this.cartDate = cartDate;
		this.pName = pName;
		this.price = price;
		this.deliFee = deliFee;
		this.point = point;
	}


	@Override
	public String toString() {
		return "Cart [memNo=" + memNo + ", pCode=" + pCode + ", amount=" + amount + ", orCycle=" + orCycle
				+ ", cartDate=" + cartDate + "]";
	}


	public Cart(int cartNo, int memNo, String pCode, String imageUrl, int amount, int orCycle, String pName, int price,
			int deliFee) {
		super();
		this.cartNo = cartNo;
		this.memNo = memNo;
		this.pCode = pCode;
		this.imageUrl = imageUrl;
		this.amount = amount;
		this.orCycle = orCycle;
		this.pName = pName;
		this.price = price;
		this.deliFee = deliFee;
	}


	public int getMemNo() {
		return memNo;
	}


	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}


	public String getpCode() {
		return pCode;
	}


	public void setpCode(String pCode) {
		this.pCode = pCode;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getOrCycle() {
		return orCycle;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public void setOrCycle(int orCycle) {
		this.orCycle = orCycle;
	}


	public Date getCartDate() {
		return cartDate;
	}


	public void setCartDate(Date cartDate) {
		this.cartDate = cartDate;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getDeliFee() {
		return deliFee;
	}


	public void setDeliFee(int deliFee) {
		this.deliFee = deliFee;
	}


	public int getCartNo() {
		return cartNo;
	}


	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}
	
	
	
	

}
