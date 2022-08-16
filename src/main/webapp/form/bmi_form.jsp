<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>BMI</title>
	</head>
	<body>
		
		<form method="post" enctype="application/x-www-form-urlencoded" action="/JavaWeb_20220815/servlet/bmi">
			<fieldset>
				<legend>BMI Form</legend>
				身高: <input type="number" id="height" name="height" placeholder="請輸入身高"><p />
				體重: <input type="number" id="weight" name="weight" placeholder="請輸入體重"><p />
				<button type="reset">清除</button>
				<button type="submit">計算</button>
			</fieldset>
		</form>
		
	</body>
</html>