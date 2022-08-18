<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>Lotto Result</title>
	</head>
	<body style="padding: 15px">
		<form class="pure-form" action="${ pageContext.request.contextPath }/form/lotto_form.jsp">
			<fieldset>
				<legend>Lotto Result</legend>
				姓名: <% out.println(request.getAttribute("username")); %> <!-- 傳統 JSP 語法 -->
					<%=request.getAttribute("username") %> <!-- 傳統 JSP 語法 --> 
					${ username } <!-- JSP EL 語法 -->
				<p />
				號碼: ${ nums }
				<p />
				<button type="submit">返回</button>
			</fieldset>
		</form>
	</body>
</html>