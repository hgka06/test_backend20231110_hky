package com.hk.board.dtos;

import java.io.Serializable;
import java.util.Date;

// DTO객체 : 데이터를 저장하고 운반하기 위한 객체 
// 데이터를 담는 용도이기 때문에 맴버필드는 은닉화로 관리함.
public class HkDto {

	private int seq;
	private String id;
	private String title;
	private String content;
	private Date regDate;
	private int refer;
	private int step;
	private int depth;
	private String readCount;
	private String delflag;
	
	public HkDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HkDto(int seq, String id, String title, String content, Date regDate, int refer, int step, int depth,
			String readCount, String delflag) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.refer = refer;
		this.step = step;
		this.depth = depth;
		this.readCount = readCount;
		this.delflag = delflag;
	}

	public HkDto(String id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public HkDto(int seq, String title, String content) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
	}

	public HkDto(int seq, String id, String title, String content) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getRefer() {
		return refer;
	}

	public void setRefer(int refer) {
		this.refer = refer;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getReadCount() {
		return readCount;
	}

	public void setReadCount(String readCount) {
		this.readCount = readCount;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	@Override
	public String toString() {
		return "HkDto [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", regDate="
				+ regDate + ", refer=" + refer + ", step=" + step + ", depth=" + depth + ", readCount=" + readCount
				+ ", delflag=" + delflag + "]";
	}
	
		

	
}
