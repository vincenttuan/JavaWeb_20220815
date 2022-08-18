<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>Lotto From</title>
	</head>
	<body style="padding: 15px">
		<form class="pure-form" method="post" action="${ pageContext.request.contextPath }/servlet/lotto">
			<fieldset>
				<legend>Lotto Form</legend>
				姓名: <input type="text" id="username" name="username" required="required" />
				<p />
				<button type="submit" class="pure-button pure-button-primary">電腦選號</button>
			</fieldset>
		</form>
	</body>
</html>