package com.hk.board.dtos;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

//@Data
@Alias(value="boardDto") //mapper.xml에서 사용하는 변수명 설정
public class BoardDto {
   private int boardid;
   private String id;
   private String title;
   private String content;
   private Date regdate;
   private String delflag;
	
   public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardDto(int boardid, String id, String title, String content, Date regdate, String delflag) {
		super();
		this.boardid = boardid;
		this.id = id;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.delflag = delflag;
	}

	public int getBoardid() {
		return boardid;
	}

	public void setBoardid(int boardid) {
		this.boardid = boardid;
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	@Override
	public String toString() {
		return "BoardDto [boardid=" + boardid + ", id=" + id + ", title=" + title + ", content=" + content
				+ ", regdate=" + regdate + ", delflag=" + delflag + "]";
	}
   
  
   
   
}