<%-- <%@page import="com.springbook.biz.board.BoardVO"%> --%>
<%@page contentType="text/html; charset=EUC-KR"%>
<%-- <%
	// 세션에 저장된 게시글 정보를 꺼낸다.
	BoardVO board = (BoardVO) session.getAttribute("board");
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
	
}

td {
	border: 1px solid #e2e2e2;
	height: 40px;
	padding: 10px;
	font-weight: 600;
}

.bocolor > th{
background-color: #ebebeb;
}

input.boardinsertbut {
	border:none;
	width: 410px;
	height: 50px;
	color: #fff;
	padding: 10px 105px;
	margin-bottom: 16px;
	background-color: #6A24FE;
	border-radius: 6px;
	font-weight: 600;
	
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 상세</title>
</head>
<body>
	<center>
		<h1>글 상세</h1>
		<a href="logout.do">Log-out</a><br>
		
		<form action="updateBoard.do" method="post">
			<input name="seq" type="hidden" value="${board.seq}" />
			<table cellpadding="0" cellspacing="0" class="bocolor">
				<tr>
					<td style="text-align: center;" width="70">제목</td>
					<td align="left"><input name="title" type="text"
						value="${board.title }" /></td>
				</tr>
				<tr>
					<td style="text-align: center;">작성자</td>
					<td align="left">${board.writer }</td>
				</tr>
				<tr>
					<td style="text-align: center;">내용</td>
					<td align="left"><textarea name="content" cols="40" rows="10">
						${board.content }</textarea></td>
				</tr>
				<tr>
					<td style="text-align: center;">등록일</td>
					<td align="left">${board.regDate }</td>
				</tr>
				<tr>
					<td style="text-align: center;">조회수</td>
					<td align="left">${board.cnt }</td>
				</tr>
				
			</table>
			<br>
			<input class="boardinsertbut" type="submit"
						value="글 수정" />
		</form>
		<br>
		<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp; <a
			href="deleteBoard.do?seq=${board.seq }">글삭제</a>&nbsp;&nbsp;&nbsp; <a
			href="getBoardList.do">글목록</a>
	</center>
</body>
</html>
