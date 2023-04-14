package com.springbook.biz.board;

//import java.sql.Date;
import java.util.Date;//regDate������ �⺻�����ڰ� �ִ�  java.util.Date Ÿ���� ������ ���� Ư�� �ڹ� ��ü�� xml�κ�ȯ�Ϸ��� �ݵ�� Ÿ���� �ڹٿ��� ��

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.web.multipart.MultipartFile;//A representation of an uploaded file received in a multipart request

import com.fasterxml.jackson.annotation.JsonIgnore;

//VO(Value Object)
@XmlAccessorType(XmlAccessType.FIELD) //BoardVO��ü�� XML�κ�ȯ XmlAccessType.FiELD ������ �� ��ü�� ���� �ʵ�  ������
public class BoardVO {
	
	@XmlAttribute //seq�������� @XmlAttribut�پ��µ� �̴� seq�� �Ӽ����� ǥ���϶�� ��
	private int seq;
	
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	
	@XmlTransient //xml��ȯ����
	private String searchCondition;
	@XmlAttribute
	private String searchKeyword;
	
	@XmlTransient
	private MultipartFile uploadFile; //���� ���ε�� ���õ� ���� �߰�
	
	
//	@JsonIgnore //json���� ������ �ʵ��� ���� getter���� ����
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	
	
	//setUploadFile() �޼��� �� ȣ��ɷ��� MultipartFileŸ���� ��ü�� �����Ǿ�� ���� MultipartFile��ü�� �ٷ� ������ �����̳ʸ� ����
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
//	@JsonIgnore //json���� ������ �ʵ��� ���� getter���� ����
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	
//	@JsonIgnore//json���� ������ �ʵ��� ���� getter���� ����
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
