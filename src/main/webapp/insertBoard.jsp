<%@page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>���۵��</title>
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

td {
	border: 1px solid #e2e2e2;
	height: 40px;
	padding: 10px;
	font-weight: 600;
}
</style>
</head>
<body>
	<center>
		<h1>�� ���</h1>
		<br>
		 <a href="logout.do">Log-out</a> <br><br>
		<!-- 230425 �۵���� �ȵǾ�  enctype="multipart/form-data"�߰� �ߴ��� �۵���� �Ǿ���!!! -->
		<form action="insertBoard.do" method="post" enctype="multipart/form-data">
			<table cellpadding="0" cellspacing="0">
				<tr>
					<td style="text-align: center;" width="70">����</td>
					<td align="left">&nbsp;<input type="text" name="title" /></td>
				</tr>
				<tr>
					<td style="text-align: center;">�ۼ���</td>
					<td align="left">&nbsp;<input type="text" name="writer"
						size="10" /></td>
				</tr>
				<tr>
					<td style="text-align: center;">����</td>
					<td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
				</tr>
				<tr>
					<td style="text-align: center;" width="70">���ε�</td>
					<td align="left"><input type="file" name="uploadFile" /></td>
				</tr>
				
			</table>
		<br> <input class="boardinsertbut" type="submit" value=" ���� ��� " /><br> <br>
		</form>
		<a href="getBoardList.do">�� ��� ����</a>
	</center>
</body>
</html>