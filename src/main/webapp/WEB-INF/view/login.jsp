<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>Login page</title>
	</head>
	<body style="padding: 15px">
		<form class="pure-form" method="post">
			<fieldset>
				<legend>登入頁面</legend>
				帳號: <input type="text" id="username" name="username" placeholder="請輸入帳號" required="required" /><p />
				密碼: <input type="password" id="password" name="password" placeholder="請輸入密碼" required="required" /><p />
				<button type="submit" class="pure-button pure-button-primary">登入</button>
			</fieldset>
		</form>
	</body>
</html>