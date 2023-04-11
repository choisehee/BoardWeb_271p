package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

//������ �����̳ʴ� @��Ʈ�ѷ��� ����� ��ü�� �ڵ����� ��Ʈ�ѷ� ��ü�� �ν��Ѵ�
//��Ʈ�ѷ� ������̼����� ����� ��Ʈ�ѷ��� @Controller�� ���� Ŭ������ ��ü�� �޸𸮿� �����ϴ� ����� ����, ������ �ܼ��� ��ü�� �����ϴ� �Ϳ� ��ġ�� �ʰ�, DispatcherServlet�� �ν��ϴ� ��Ʈ�ѷ� ��ü�� ����� ��
//@Controller
public class InsertBoardController {

	//������������ @RequestMapping�� �̿��Ͽ� HandlerMapping ������ ��ü�Ѵ�
	//Annotation for mapping web requests onto specific handler classes and/orhandler methods. 
	//Provides a consistent style between Servlet and Portletenvironments, 
	//with the semantics adapting to the concrete environment. 
	@RequestMapping(value="/insertBoard.do")
	public String InsertBoard(BoardVO vo,BoardDAO boardDAO) {
	// ����ڰ� �Է��ϴ� ������ ���ų� ����Ǵ� ��Ȳ������ ��Ʈ�ѷ� Ŭ������ ����Ǿ�� �ϹǷ� ������, �׷��� �Ű������� ���� VO��ü�� �̿��ϸ� �ȴ�
		System.out.println("�� ��� ó��");
		//������ �����̳ʰ� InsertBoard()�޼ҵ带 ������ �� ����ڰ� �Է��� ���� BoardDAO��ü�� �����ؼ� �Ѱ���
		//��������� ����� �Է� ���� ����� VO ��ü ����, �׸��� �� ������ ��� �����̳ʰ� �ڵ����� ó��	
		//DAO ��ü ���� �谳������ �����ϸ� ������ �����̳ʰ� �ش��ϴ� ��ü�� �����Ͽ� ��������

		// 1. ����� �Է� ���� ����
		// request.setCharacterEncoding("EUC-KR");
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");
		
		// 2. DB ���� ó��
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		vo.setContent(content);
		
		
		//Ŭ���̾�Ʈ�� �� ����� ��û�ϸ� ������ �����̳ʴ� InsertBoardController��ü��
		//InsertBoard()�޼ҵ带 ȣ��
		//�� �� ������ �ش��ϴ� BoardVO��ü�� �����ϰ�
		//����ڰ� �Է��� �Ķ�̳�(title,writer,content)������ �����ϰ� BoardVO��ü�� ����
		//�� �� BoardVOŬ������ Setter �޼ҵ� ȣ��
		//InsertBoard() �޼ҵ� ȣ��� ����� �Է°����� ������ BoardVO ��ü�� ���ڷ� ����
		//���⼭ �߿��� ��(������ �� ���� ����)�� Form�±� �ȿ� �Ķ���� �̸��� ��ü�� Setter�޼ҵ� �̸��� �ݵ�� ��ġ�ؾ� ��
		//�� �Ķ���� �̸��� �ش��ϴ� setTitle(), setWriter(), setContent()�޼ҵ尡 �־�� Setter �����ǿ� ���� �ڵ����� �Ķ���� ��
//		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
		
		
	}
	
	
	

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("�� ��� ó��");
//
//		// 1. ����� �Է� ���� ����
//		// request.setCharacterEncoding("EUC-KR");
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");
//
//		// 2. DB ���� ó��
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		vo.setContent(content);
//
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.insertBoard(vo);
//
//		// 3. ȭ�� �׺���̼�
//		// return "getBoardList.do";// �� ��Ͽ� �����ϸ� ��ϵ� ���� ���Ե� �� ����� �ٽ� �˻��ؾ��� ����
//		// getBoardList.do���ڿ��� �����Ͽ� �����̷�Ʈ ó��
//
//		// 3. ȭ�� �׺���̼�
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
//		return mav;
//
//	}

}
