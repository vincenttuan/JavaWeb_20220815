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
	現在時刻: <%=new Date() %><br />
	context path: ${ pageContext.request.contextPath }
	<ul>
		<li><a href="${ pageContext.request.contextPath }/servlet/hello?username=John">HelloServlet 帶參數 username=John</a></li>
		<li><a href="${ pageContext.request.contextPath }/servlet/welcome">WelcomeServlet(配合 insomnia 操作)</a></li>
		<li><a href="${ pageContext.request.contextPath }/form/bmi_form.jsp">bmi_form.jsp</a></li>
		<li><a href="${ pageContext.request.contextPath }/form/program_form.jsp">program_form.jsp</a></li>
		<li><a href="${ pageContext.request.contextPath }/servlet/image?name=f18">ImageServlet 帶參數 name=f18</a></li>
		<li><a href="${ pageContext.request.contextPath }/form/exchange_form.jsp">exchange_form.jsp</a></li>
	</ul>
</body>
</html>