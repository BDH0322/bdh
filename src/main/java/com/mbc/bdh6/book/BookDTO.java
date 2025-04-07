package com.mbc.bdh6.book;

public class BookDTO {

	public BookDTO(String bname, String bwriter, String bmemo, String bimage, String bdate, int bprice, int readcnt,
			int bnumber) {
		super();
		this.bname = bname;
		this.bwriter = bwriter;
		this.bmemo = bmemo;
		this.bimage = bimage;
		this.bdate = bdate;
		this.bprice = bprice;
		this.readcnt = readcnt;
		this.bnumber = bnumber;
	}
	public BookDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	String bname,bwriter,bmemo,bimage,bdate;
	int bprice, readcnt, bnumber;
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public String getBmemo() {
		return bmemo;
	}
	public void setBmemo(String bmemo) {
		this.bmemo = bmemo;
	}
	public String getBimage() {
		return bimage;
	}
	public void setBimage(String bimage) {
		this.bimage = bimage;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int getBprice() {
		return bprice;
	}
	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public int getBnumber() {
		return bnumber;
	}
	public void setBnumber(int bnumber) {
		this.bnumber = bnumber;
	}
	
}
