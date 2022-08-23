<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>Error page</title>
	</head>
	<body style="padding: 15px">
		<form class="pure-form">
			<fieldset>
				<legend>錯誤處理</legend>
				錯誤物件: <%=exception.getClass().getSimpleName() %><p />
				錯誤訊息: <%=exception.getMessage() %><p />
				<button type="button" 
						onclick="location.href='${ pageContext.request.contextPath }/';" 
						class="pure-button">回首頁</button>
			</fieldset>
		</form>
	</body>
</html>