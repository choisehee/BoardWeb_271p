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
// @SessionAttributes이용하면 세션에 저장된 정보를 null로 나오지 않는다
public class BoardController {

	@Autowired
	private BoardService boardService;

	// @ModelAttribute는 객체의 이름의 변경할 목적으로도 사용하지만 View(JSP)에서 사용할 데이터를 설정하는 용도로도 사용가능
	// @ModelAttribute가 설정된 메서드는 @RequestMapping어노테이션이 적용된 메서드보다 먼저 호출
	// @ModelAttribute 메소드 실행결과로 리턴 객체는 자동으로 Model에 저장된다 따라서
	// @ModelAttribute 메소드 실행결과로 리턴된 객체를 View페이지에서 사용가능

	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		System.out.println("conditionMap : " + conditionMap);
		return conditionMap;
	}

	// 글 등록
	@RequestMapping(value = "/insertBoard.do") // BoardVO 객체 생성시 MultipartFile 객체를 생성하고 할당, 그런데 multipartResolver라는 이름으로
												// 등록된 CommonsMultipartResolver 객체가 없으면 스프링 컨테이너는MultipartFile객체를 생성할 수
												// 없다
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) throws IOException {

		// 파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		
		if (!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("D:\\boardWedFile" + fileName));
		}

//		boardDAO.insertBoard(vo);
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}

	// 글 수정
	@RequestMapping(value = "/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
		System.out.println("번호 : " + vo.getSeq());
		System.out.println("제목 : " + vo.getTitle());
		System.out.println("작성자 : " + vo.getWriter());
		System.out.println("내용 : " + vo.getContent());
		System.out.println("등록일 : " + vo.getRegDate());
		System.out.println("조회수 : " + vo.getCnt());

		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}

	// 글 삭제
	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}

	// 글 상세 조회
	@RequestMapping(value = "/getBoard.do")
	// model에도 board라는 이름으로 boarvo객체가 저장됨 왜냐하면 @SessionAttributes("board") 설정으로 인해서
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		// 메소드마다 리턴타입을 다르게 하는 것보다는 String으로 통일하는 것이 더 간결하기에 대부분 String으로 통일한다.
		// ModelAndView에 저장했던 검색 결과는 이제 Model에 저장, 이렇게 모델에 저장된 데이터는 ModelAndView와 동일하게
		model.addAttribute("board", boardDAO.getBoard(vo));// Model 정보 저장
//			mav.addObject("board", boardDAO.getBoard(vo)); // Model 정보 저장
//			mav.setViewName("getBoard.jsp"); // View 정보 저장
		return "getBoard.jsp";
	}

	// 글 목록 검색1
//	@RequestMapping(value = "/getBoardList.do")
//	public String getBoardList(
//			@RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) String condition, 
//			@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword,
//			BoardVO vo,BoardDAO boardDAO, Model model) {
	// @RequestParam: Annotation which indicates that a method parameter should be
	// bound to a webrequest parameter
	// Spring MVC에서는 HTTP 요청 파라미터 정보를 수출하기 위한 @RequestParam를 제공함
	// @RequestParam은 HTTPServletRequest에서 제공하는 겟파라미터()aptjemdhk rkxdms rlsmddml

//		System.out.println("검색조건 : " + condition);
//		System.out.println("검색단어 : " + keyword);

//		model.addAttribute("boardList", boardDAO.getBoardList(vo));
////		 mav.addObject("boardList", boardDAO.getBoardList(vo)); // Model 정보 저장
////			mav.setViewName("getBoardList.jsp"); // View 정보 저장
//		return "getBoardList.jsp";// View 이름 리턴
//	}

	// 글 목록 검색2
	@RequestMapping(value = "/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		// Null Check, 검색 조건과 검색 키워드가 전달되지 않을 때를 위하여 (예를 들면 로그인 성공 후
		// "getBoardList.do"요청이 전달되거나 상세화면에서 글 목록 링크를 클릭하여
		// BoardVO객체의 sarchCondition과 SearchKeyword 변수에는 null이 설정됨, 따라서 이럴 때는 기본값을 설정하여
		// 비즈니스 컴포넌트에 전달
		System.out.println("getSearchCondition : " + vo.getSearchCondition());
		if (vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		// Model 정보 저장
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp"; // View 이름 리턴

	}

}
