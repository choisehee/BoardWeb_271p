<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title><spring:message code="message.user.login.title" /></title>
<style type="text/css">
body {
	font-size: 17px;
	font-family: 'Roboto', sans-serif;
}
center{
 color: #D2D2D2;
}


.login-wrapper {
   
	width: 400px;
	height: 500px;
	padding: 40px;
	box-sizing: border-box;
	
}

form{
	
}

.login-wrapper>h1 {
	font-size: 40px;
	color: #6A24FE;
	margin-bottom: 20px;
}

table, tr, td {
	border: none;
}

input {
	border: none;
	width: 100%;
	height: 48px;
	padding: 0 10px;
	box-sizing: border-box;
	margin-bottom: 16px;
	border-radius: 6px;
	background-color: #ebebeb;
}

#login-form > input::placeholder{

    color: black;
    opacity: 0.6;
    font-weight: 600;
}

#login-form > input[type="submit"]{
    color: #fff;

    background-color: #6A24FE;
    margin-top: 20px;
}



.lang {
	width: 200px;
	height: 25px;
    display: inline-block;
}





.lang a {
	margin-right: 10px;
    font-size: 13px;
    color: #222;
    box-sizing: border-box;
    text-decoration: none;
}


.loginbut:hover {
	cursor: pointer;
}


</style>
</head>
<body>
	<center>
		<div class="login-wrapper">
			<h1>
				<spring:message code="message.user.login.title" />
			</h1>
			

			
			<form action="login.do" method="post" id="login-form">
			<br>
				<input type="text" name="id" placeholder="<spring:message code='message.user.login.id' />" value="${user.id}" />
				<input type="text" name="password" placeholder="<spring:message code='message.user.login.password' />" value="${user.password }" />
				<br> 
				<input class="loginbut" type="submit" value="<spring:message code="message.user.login.loginBtn"/>"/>
			</form>
			
			<br>
			
			<div class="lang">
				<a href="login.do?lang=en" > <spring:message
					code="message.user.login.language.en" /></a>

				<a
				href="login.do?lang=ko"> <spring:message
					code="message.user.login.language.ko" /></a>
			</div>
			 
		</div>
	</center>
</body>
</html>