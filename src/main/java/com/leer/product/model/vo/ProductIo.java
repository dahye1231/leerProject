package com.leer.product.model.vo;

import java.sql.Date;

public class ProductIo {// 상품 입고|출고 테이블
	
	private int statusNo;
	private String pCode;
	private int statusAmount;
	private Date statusDate;
	private String status;
	private String pName; // product 테이블 조인
	private String statusDate2; // 입고 등록 시 string형으로 변환
	
	public ProductIo() {}

	public ProductIo(int statusNo, String pCode, int statusAmount, Date statusDate, String status) {
		super();
		this.statusNo = statusNo;
		this.pCode = pCode;
		this.statusAmount = statusAmount;
		this.statusDate = statusDate;
		this.status = status;
	}

	public ProductIo(int statusNo, String pCode, String pName, int statusAmount, Date statusDate, String status) {
		super();
		this.statusNo = statusNo;
		this.pCode = pCode;
		this.pName = pName;
		this.statusAmount = statusAmount;
		this.statusDate = statusDate;
		this.status = status;
	}
	
	public ProductIo(int statusNo, String pCode, String status, int statusAmount, String statusDate2) {
		super();
		this.statusNo = statusNo;
		this.pCode = pCode;
		this.statusAmount = statusAmount;
		this.status = status;
		this.statusDate2 = statusDate2;
	}
	
	public int getStatusNo() {
		return statusNo;
	}

	public String getStatusDate2() {
		return statusDate2;
	}
	
	public void setStatusDate2(String statusDate2) {
		this.statusDate2 = statusDate2;
	}
	
	public void setStatusNo(int statusNo) {
		this.statusNo = statusNo;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public int getStatusAmount() {
		return statusAmount;
	}

	public void setStatusAmount(int statusAmount) {
		this.statusAmount = statusAmount;
	}

	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	@Override
	public String toString() {
		return "ProductIo [statusNo=" + statusNo + ", pCode=" + pCode + ", statusAmount=" + statusAmount
				+ ", statusDate=" + statusDate + ", status=" + status + "]";
	}
	
	
}
