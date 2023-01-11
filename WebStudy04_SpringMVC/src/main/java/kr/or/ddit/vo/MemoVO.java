package kr.or.ddit.vo;

import java.io.Serializable;

// 객체를 직렬화 하려면 그 객체가 가지고 있는 property도 직렬화 할 수 있어야 한다 (ex. Object 타입이 존재하면 직렬화X..)
public class MemoVO implements Serializable{
	
	private Integer code;
	private String writer;
	private String content;
	private String date;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "MemoVO [code=" + code + ", writer=" + writer + ", content=" + content + ", date=" + date + "]";
	}
}
