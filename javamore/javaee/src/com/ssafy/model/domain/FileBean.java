package com.ssafy.model.domain;

public class FileBean {
	private int no;
	private String filename;			
	private String rfilename;			
	private int bno;
	public FileBean(){}
	public FileBean(String filename, String rfilename) {
		this.filename = filename;
		this.rfilename = rfilename;
	}
	public FileBean(String filename, String rfilename, int no) {
		this.filename = filename;
		this.rfilename = rfilename;
		this.bno = no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getRfilename() {
		return rfilename;
	}
	public void setRfilename(String rfilename) {
		this.rfilename = rfilename;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FileBean [fileName=").append(filename)
				.append(", rfileName=").append(rfilename).append("]");
		return builder.toString();
	}
}
