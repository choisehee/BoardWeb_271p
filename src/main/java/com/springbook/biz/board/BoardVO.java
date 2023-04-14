package com.springbook.biz.board;

//import java.sql.Date;
import java.util.Date;//regDate변수를 기본생성자가 있는  java.util.Date 타입의 변수로 변경 특정 자바 객체를 xml로변환하려면 반드시 타입이 자바여야 함

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.web.multipart.MultipartFile;//A representation of an uploaded file received in a multipart request

import com.fasterxml.jackson.annotation.JsonIgnore;

//VO(Value Object)
@XmlAccessorType(XmlAccessType.FIELD) //BoardVO객체를 XML로변환 XmlAccessType.FiELD 떄문에 이 객체가 가진 필드  즉면수들
public class BoardVO {
	
	@XmlAttribute //seq벼누에만 @XmlAttribut붙었는데 이는 seq를 속성으로 표현하라는 뜻
	private int seq;
	
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	
	@XmlTransient //xml변환제외
	private String searchCondition;
	@XmlAttribute
	private String searchKeyword;
	
	@XmlTransient
	private MultipartFile uploadFile; //파일 업로드와 관련되 변수 추가
	
	
//	@JsonIgnore //json으로 나오지 않도록 제외 getter위에 설정
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	
	
	//setUploadFile() 메서드 가 호출될려면 MultipartFile타입의 객체가 생성되어야 함이 MultipartFile객체는 바로 스프링 컨테이너를 생성
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
//	@JsonIgnore //json으로 나오지 않도록 제외 getter위에 설정
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	
//	@JsonIgnore//json으로 나오지 않도록 제외 getter위에 설정
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="+ regDate + ", cnt=" + cnt + "]";
	}
	
	

}
