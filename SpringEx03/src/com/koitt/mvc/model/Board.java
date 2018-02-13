package com.koitt.mvc.model;

import java.io.Serializable;
import java.util.Date;

public class Board implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer no;
	private String title;
	private String content;
	private Integer userNo;
	private Date regDate;

	public Board() {
	}

	public Board(Integer no, String title, String content, Integer userNo, Date regDate) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.userNo = userNo;
		this.regDate = regDate;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
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

	public Integer getuserNo() {
		return userNo;
	}

	public void setuserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((userNo == null) ? 0 : userNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Board)) {
			return false;
		}

		Board other = (Board) obj;
		if (this.no.equals(other.no)) {
			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board [no=");
		builder.append(no);
		builder.append(", title=");
		builder.append(title);
		builder.append(", content=");
		builder.append(content);
		builder.append(", userNo=");
		builder.append(userNo);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append("]");
		return builder.toString();
	}
}