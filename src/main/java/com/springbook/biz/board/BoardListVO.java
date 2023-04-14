package com.springbook.biz.board;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//xml문서는 반드시 단 하나의 루트 엘리먼트를 가져야 한다 여러 게시글 목록을 xml로 표현해야 하므로 BoardVO 객체 여러개를 
//루트 엘리먼트로 사용할 또 다른 자바 클래스 필요
@XmlRootElement(name = "boardList")//루트 엘리먼트로 설정
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardListVO {
	@XmlElement(name = "board")//이 설정이 없으면 boardList가 엘리먼트 이름으로 사용에 따라서 board로 변경
	private List<BoardVO> boardList;

	public List<BoardVO> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<BoardVO> boardList) {
		this.boardList = boardList;
	}
}