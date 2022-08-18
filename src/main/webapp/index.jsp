<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
</head>
<body>
	現在時刻: <%=new Date() %>
	<ul>
		<li><a href="/JavaWeb_20220815/servlet/hello?username=John">HelloServlet 帶參數 username=John</a></li>
		<li><a href="/JavaWeb_20220815/servlet/welcome">WelcomeServlet(配合 insomnia 操作)</a></li>
		<li><a href="/JavaWeb_20220815/form/bmi_form.jsp">bmi_form.jsp</a></li>
		<li><a href="/JavaWeb_20220815/form/program_form.jsp">program_form.jsp</a></li>
		<li><a href="/JavaWeb_20220815/servlet/image?name=f18">ImageServlet 帶參數 name=f18</a></li>
		<li><a href="/JavaWeb_20220815/form/exchange_form.jsp">exchange_form.jsp</a></li>
	</ul>
</body>
</html>