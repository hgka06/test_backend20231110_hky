package com.hk.board.dtos;

import java.sql.Date;

import lombok.Data;

@Data
public class CalDto {
	
	private int checkid;
	private String id;
	private String title;
	private String content;
	private String mdate;
	private Date regdate;
	
	public CalDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CalDto(int checkid, String id, String title, String content, String mdate, Date regdate) {
		super();
		this.checkid = checkid;
		this.id = id;
		this.title = title;
		this.content = content;
		this.mdate = mdate;
		this.regdate = regdate;
	}

	public int getCheckid() {
		return checkid;
	}

	public void setCheckid(int checkid) {
		this.checkid = checkid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "CalDto [checkid=" + checkid + ", id=" + id + ", title=" + title + ", content=" + content + ", mdate="
				+ mdate + ", regdate=" + regdate + "]";
	}
	
	
}
