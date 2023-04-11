package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

//스프링 컨테이너는 @컨트롤러가 선언된 객체를 자동으로 컨트롤러 객체로 인식한다
//컨트롤러 어노테이션으로 상속한 컨트롤러는 @Controller가 붙은 클래스의 객체를 메모리에 생성하는 기능을 제공, 하지만 단순히 객체를 생성하는 것에 그치지 않고, DispatcherServlet이 인식하는 컨트롤러 객체로 만들어 줌
//@Controller
public class InsertBoardController {

	//스프링에서는 @RequestMapping을 이용하여 HandlerMapping 설정을 대체한다
	//Annotation for mapping web requests onto specific handler classes and/orhandler methods. 
	//Provides a consistent style between Servlet and Portletenvironments, 
	//with the semantics adapting to the concrete environment. 
	@RequestMapping(value="/insertBoard.do")
	public String InsertBoard(BoardVO vo,BoardDAO boardDAO) {
	// 사용자가 입력하는 정보가 많거나 변경되는 상황에서는 컨트롤러 클래스가 변경되어야 하므로 불편함, 그래서 매개변수로 받은 VO객체를 이용하면 된다
		System.out.println("글 등록 처리");
		//스프링 컨테이너가 InsertBoard()메소드를 실행할 때 사용자가 입력한 값을 BoardDAO객체에 셋팅해서 넘겨줌
		//결과적으로 사용자 입력 정보 추출과 VO 객체 생성, 그리고 값 설정을 모두 컨테이너가 자동으로 처리	
		//DAO 객체 역시 배개변수로 선언하면 스프링 컨테이너가 해당하는 객체를 생성하여 전달해줌

		// 1. 사용자 입력 정보 추출
		// request.setCharacterEncoding("EUC-KR");
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");
		
		// 2. DB 연동 처리
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		vo.setContent(content);
		
		
		//클라이언트가 글 등록을 요청하면 스프링 컨테이너는 InsertBoardController객체의
		//InsertBoard()메소드를 호출
		//이 때 변수에 해당하는 BoardVO객체를 생성하고
		//사용자가 입력한 파라미너(title,writer,content)값들을 추출하고 BoardVO객체에 저장
		//이 때 BoardVO클래스의 Setter 메소드 호출
		//InsertBoard() 메소드 호출시 사용자 입력값들이 설정되 BoardVO 객체가 인자로 전달
		//여기서 중요한 점(에러가 잘 나는 요인)은 Form태그 안에 파라미터 이름과 객체의 Setter메소드 이름이 반드시 일치해야 함
		//각 파라미터 이름에 해당하는 setTitle(), setWriter(), setContent()메소드가 있어야 Setter 인젝션에 의해 자동으로 파라미터 됨
//		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
		
		
	}
	
	
	

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("글 등록 처리");
//
//		// 1. 사용자 입력 정보 추출
//		// request.setCharacterEncoding("EUC-KR");
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");
//
//		// 2. DB 연동 처리
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		vo.setContent(content);
//
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.insertBoard(vo);
//
//		// 3. 화면 네비게이션
//		// return "getBoardList.do";// 글 등록에 성공하면 등록된 글이 포함된 글 목록을 다시 검색해야함 따라서
//		// getBoardList.do문자열을 리턴하여 리다이렉트 처리
//
//		// 3. 화면 네비게이션
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
//		return mav;
//
//	}

}
