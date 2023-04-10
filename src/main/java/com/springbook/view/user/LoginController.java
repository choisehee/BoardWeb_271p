package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller; //어떤 Controller 객체가 검색되더라도 같은 코드로 실행하려면 모든 컨트롤의 최상위 인터페이스 필요

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;//스프링 제공

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("로그인 처리");

		// 1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		System.out.println("입력한 아이디 비번 : " + id + " " + password);

		// 2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);

		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);

		// 3. 화면 네비게이션 redirect:를 붙이면 ViewResolver가 설정되어 있더라도 이를 무시하고 리다이렉트함
		ModelAndView mav = new ModelAndView();
		if (user != null) {
			mav.setViewName("redirect:getBoardList.do");
		} else {
			mav.setViewName("redirect:login.jsp");
		}
		return mav;

	}

}
