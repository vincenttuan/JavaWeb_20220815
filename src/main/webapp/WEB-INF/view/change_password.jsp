<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>修改密碼</title>
		<script type="text/javascript">
			function verifyPassword() {
				if(new_password.value == new_password2.value) {
					return true;
				}
				alert('二次新密碼必須輸入一致')
				return false;
			}
		</script>
	</head>
	<body style="padding: 15px">
		<form class="pure-form" 
			  onsubmit="return verifyPassword();" 
			  method="post" 
			  action="${ pageContext.request.contextPath }/mvc/user/password">
			<fieldset>
				<legend>修改密碼</legend>
				id序號: <input type="text" value="${ id }" id="id" name="id" readonly="readonly" /><p />
				舊密碼: <input type="text" id="password" name="password" required="required" /><p />
				新密碼: <input type="text" id="new_password" name="new_password" required="required" /><p />
				新密碼: <input type="text" id="new_password2" name="new_password2" required="required" /> 請再輸入一次<p />
				<button type="submit" class="pure-button pure-button-primary">修改</button>
				<button type="button" 
						onclick="location.href='${ pageContext.request.contextPath }/mvc/user/';"
						class="pure-button pure-button-primary">取消</button><p />
			</fieldset>
		</form>
	</body>
</html>