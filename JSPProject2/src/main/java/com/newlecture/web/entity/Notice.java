package com.newlecture.web.entity;

import java.util.Date;

public class Notice {
	private int id;
	private String title;
	private String writerID;
	private Date regdate;
	private String hit;
	private String files;
	private String content;
	
	public Notice() {
		
	}
	
	public Notice(int id, String title, String writerID, Date regdate, String hit, String files, String content) {
		this.id = id;
		this.title = title;
		this.writerID = writerID;
		this.regdate = regdate;
		this.hit = hit;
		this.files = files;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriterID() {
		return writerID;
	}

	public void setWriterID(String writerID) {
		this.writerID = writerID;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", writerID=" + writerID + ", regdate=" + regdate + ", hit="
				+ hit + ", files=" + files + ", content=" + content + "]";
	}
	
	
}
