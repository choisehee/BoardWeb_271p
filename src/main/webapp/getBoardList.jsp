<%-- <%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.BoardVO"%> --%>
<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%-- <%
	// 세션에 저장된 글 목록을 꺼낸다. 이파일은 이제 더이상 DB연동을 하지 않는다 컨트롤에서 한다
	List<BoardVO> boardList = (List) session.getAttribute("boardList");
%> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {
	font-size: 17px;
	font-family: 'Roboto', sans-serif;
}

a {
	text-decoration: none;
	color: black;
}

center>h1 {
	font-size: 40px;
	color: #6A24FE;
	margin-bottom: 20px;
	 
}

td, th {
	height: 40px;
	border: 1px solid #e2e2e2;
}

.margin_right{
width:719px;
margin-right:20px;
}

.bocolor > th{
background-color: #ebebeb;
}

#fontseter {
	text-align: center;
}
.boardinsertbut{
	width: 700px;
	height: 100px;
	color:#fff;
	padding: 16px 305px;
	box-sizing: border-box;
	margin-bottom: 16px;
	border-radius: 6px;
	background-color: #6A24FE;
	font-weight: 600;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 목록</title>
</head>
<body>
	<center>
		<h1>
			<spring:message code="message.board.list.mainTitle" />
		</h1>
		<h3>${userName }<spring:message
				code="message.board.list.welcomeMsg" />
			... <a href="logout.do">Log-out</a>
		</h3>
		<!-- 검색 시작 -->
		<form action="getBoardList.do" method="post">
				<div align="right"  class="margin_right">
				<select name="searchCondition">
					<c:forEach items="${conditionMap }" var="option">
						<option value="${option.value }">${option.key }
					</c:forEach>
				</select> <input name="searchKeyword" type="text" /> <input type="submit"
					value="<spring:message code="message.board.list.search.condition.btn"/>" />
			</div>
			
		</form>
		
		<br>
		<!-- 검색 종료 -->
		<table cellpadding="0" cellspacing="0" width="700">
			<tr class="bocolor">
				<th width="100"><spring:message
						code="message.board.list.table.head.seq" /></th>
				<th width="200"><spring:message
						code="message.board.list.table.head.title" /></th>
				<th width="150"><spring:message
						code="message.board.list.table.head.writer" /></th>
				<th width="430"><spring:message
						code="message.board.list.table.head.regDate" /></th>
				<th width="100"><spring:message
						code="message.board.list.table.head.cnt" /></th>
			</tr>
			<c:forEach items="${boardList }" var="board">
				<tr id="border">
					<td id="fontseter">${board.seq }</td>
					<td align="left"><a href="getBoard.do?seq=${board.seq }">
							${board.title }</a></td>
					<td>${board.writer }</td>
					<td>${board.regDate }</td>
					<td>${board.cnt }</td>
				</tr>
			</c:forEach>
		</table>
		<br> <a class="boardinsertbut" href="insertBoard.jsp"><spring:message
				code="message.board.list.link.insertBoard" /></a>
	</center>
</body>
</html>