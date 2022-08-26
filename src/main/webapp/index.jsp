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
		<li><a href="${ pageContext.request.contextPath }/servlet/lotto">/servlet/lotto (MVC 版)</a></li>
		<hr />
		<li><a href="${ pageContext.request.contextPath }/form/drink_form.html">/form/drink_form.html (REST/JPA)</a></li>
		<hr />
		<li><a href="${ pageContext.request.contextPath }/mvc/user/">/mvc/user/ (會員 JDBC)</a></li>
		<li><a href="${ pageContext.request.contextPath }/mvc/book/">/mvc/book/ (庫存 REST/JDBC)</a></li>
		<li><a href="${ pageContext.request.contextPath }/mvc/buy/book/">/mvc/buy/book/ (購物 REST/JDBC)</a></li>
		<li><a href="${ pageContext.request.contextPath }/mvc/cart/book/">/mvc/cart/book/ (購物車 REST/JDBC)</a></li>
		<li><a href="${ pageContext.request.contextPath }/websocket/client.jsp">/websocket/client.jsp (聊天室 WebSocket)</a></li>
	</ul>
</body>
</html>