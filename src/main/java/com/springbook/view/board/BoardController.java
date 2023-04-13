package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller //
@SessionAttributes("board")
// @SessionAttributes�̿��ϸ� ���ǿ� ����� ������ null�� ������ �ʴ´�
public class BoardController {

	@Autowired
	private BoardService boardService;

	// @ModelAttribute�� ��ü�� �̸��� ������ �������ε� ��������� View(JSP)���� ����� �����͸� �����ϴ� �뵵�ε� ��밡��
	// @ModelAttribute�� ������ �޼���� @RequestMapping������̼��� ����� �޼��庸�� ���� ȣ��
	// @ModelAttribute �޼ҵ� �������� ���� ��ü�� �ڵ����� Model�� ����ȴ� ����
	// @ModelAttribute �޼ҵ� �������� ���ϵ� ��ü�� View���������� ��밡��

	// �˻� ���� ��� ����
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("����", "TITLE");
		conditionMap.put("����", "CONTENT");
		System.out.println("conditionMap : " + conditionMap);
		return conditionMap;
	}

	// �� ���
	@RequestMapping(value = "/insertBoard.do") // BoardVO ��ü ������ MultipartFile ��ü�� �����ϰ� �Ҵ�, �׷��� multipartResolver��� �̸�����
												// ��ϵ� CommonsMultipartResolver ��ü�� ������ ������ �����̳ʴ�MultipartFile��ü�� ������ ��
												// ����
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) throws IOException {

		// ���� ���ε� ó��
		MultipartFile uploadFile = vo.getUploadFile();
		
		if (!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("D:\\boardWedFile" + fileName));
		}

//		boardDAO.insertBoard(vo);
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}

	// �� ����
	@RequestMapping(value = "/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
		System.out.println("��ȣ : " + vo.getSeq());
		System.out.println("���� : " + vo.getTitle());
		System.out.println("�ۼ��� : " + vo.getWriter());
		System.out.println("���� : " + vo.getContent());
		System.out.println("����� : " + vo.getRegDate());
		System.out.println("��ȸ�� : " + vo.getCnt());

		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}

	// �� ����
	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}

	// �� �� ��ȸ
	@RequestMapping(value = "/getBoard.do")
	// model���� board��� �̸����� boarvo��ü�� ����� �ֳ��ϸ� @SessionAttributes("board") �������� ���ؼ�
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		// �޼ҵ帶�� ����Ÿ���� �ٸ��� �ϴ� �ͺ��ٴ� String���� �����ϴ� ���� �� �����ϱ⿡ ��κ� String���� �����Ѵ�.
		// ModelAndView�� �����ߴ� �˻� ����� ���� Model�� ����, �̷��� �𵨿� ����� �����ʹ� ModelAndView�� �����ϰ�
		model.addAttribute("board", boardDAO.getBoard(vo));// Model ���� ����
//			mav.addObject("board", boardDAO.getBoard(vo)); // Model ���� ����
//			mav.setViewName("getBoard.jsp"); // View ���� ����
		return "getBoard.jsp";
	}

	// �� ��� �˻�1
//	@RequestMapping(value = "/getBoardList.do")
//	public String getBoardList(
//			@RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) String condition, 
//			@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword,
//			BoardVO vo,BoardDAO boardDAO, Model model) {
	// @RequestParam: Annotation which indicates that a method parameter should be
	// bound to a webrequest parameter
	// Spring MVC������ HTTP ��û �Ķ���� ������ �����ϱ� ���� @RequestParam�� ������
	// @RequestParam�� HTTPServletRequest���� �����ϴ� ���Ķ����()aptjemdhk rkxdms rlsmddml

//		System.out.println("�˻����� : " + condition);
//		System.out.println("�˻��ܾ� : " + keyword);

//		model.addAttribute("boardList", boardDAO.getBoardList(vo));
////		 mav.addObject("boardList", boardDAO.getBoardList(vo)); // Model ���� ����
////			mav.setViewName("getBoardList.jsp"); // View ���� ����
//		return "getBoardList.jsp";// View �̸� ����
//	}

	// �� ��� �˻�2
	@RequestMapping(value = "/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		// Null Check, �˻� ���ǰ� �˻� Ű���尡 ���޵��� ���� ���� ���Ͽ� (���� ��� �α��� ���� ��
		// "getBoardList.do"��û�� ���޵ǰų� ��ȭ�鿡�� �� ��� ��ũ�� Ŭ���Ͽ�
		// BoardVO��ü�� sarchCondition�� SearchKeyword �������� null�� ������, ���� �̷� ���� �⺻���� �����Ͽ�
		// ����Ͻ� ������Ʈ�� ����
		System.out.println("getSearchCondition : " + vo.getSearchCondition());
		if (vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		// Model ���� ����
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp"; // View �̸� ����

	}

}
