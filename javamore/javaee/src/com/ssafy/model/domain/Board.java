package com.ssafy.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
public class Board implements Serializable {
	private  int no;
	private  String title;
	private  String id;
	private  String regdate;
	private  String content;
	private  ArrayList<FileBean> fileBean;
	public Board() { }
	public Board(int no, String title, String id, String regdate, String content) {
		setNo(no);
		setTitle(title);
		setId(id);
		setRegdate(regdate);
		setContent(content);
	}
	public Board(int no, String title, String id, String regdate, String content, ArrayList<FileBean>  fileBean) {
		setNo(no);
		setTitle(title);
		setId(id);
		setRegdate(regdate);
		setContent(content);
		setFileBean(fileBean);
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public ArrayList<FileBean> getFileBean() {
		return fileBean;
	}
	public void setFileBean(ArrayList<FileBean> fileBean) {
		this.fileBean = fileBean;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board [no=").append(no).append(", title=")
				.append(title).append(", id=").append(id).append(", regdate=")
				.append(regdate).append(", content=").append(content)
				.append(", files=").append(fileBean)
				.append("]");
		return builder.toString();
	}
}	
