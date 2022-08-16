<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>BMI</title>
		<script type="text/javascript">
			function checkData() {
				var h = document.getElementById('height');
				var w = document.getElementById('weight');
				// trim() 左右去除空白
				// length 資料長度
				console.log(h.value.trim().length == 0); // log 紀錄 (在 chrome 中按下 F12 選擇 console 標籤即可以看到資料)
				console.log(w.value.trim().length == 0); // log 紀錄
				if(h.value.trim().length == 0) {
					alert('請輸入身高 !');
					h.focus(); // 回到身高欄位焦點
					return false;
				}
				if(w.value.trim().length == 0) {
					alert('請輸入體重 !');
					w.focus(); // 回到體重欄位焦點
					return false;
				}
				return true;
			}
			
			function update(value, tagName) {
				document.getElementById(tagName).innerText = value;
			}
		</script>
	</head>
	<body>
		
		<form method="post" onsubmit="return checkData()" enctype="application/x-www-form-urlencoded" action="/JavaWeb_20220815/servlet/bmi">
			<fieldset>
				<legend>BMI Form 1</legend>
				身高: <input type="number" id="height" name="height" placeholder="請輸入身高" required="required"><p />
				體重: <input type="number" id="weight" name="weight" placeholder="請輸入體重" required="required"><p />
				<button type="reset">清除</button>
				<button type="submit">計算</button>
			</fieldset>
		</form>
		<p />
		<form method="post" action="/JavaWeb_20220815/servlet/bmi">
			<fieldset>
				<legend>BMI Form 2</legend>
				身高: <input type="range" id="height" name="height" min="1" max="300" onmousemove="update(this.value, 'height_value')" onchange="update(this.value, 'height_value')"> <span id="height_value"></span><p />
				體重: <input type="range" id="weight" name="weight" min="1" max="300" onmousemove="update(this.value, 'weight_value')" onchange="update(this.value, 'weight_value')"> <span id="weight_value"></span><p />
				<button type="reset">清除</button>
				<button type="submit">計算</button>
			</fieldset>
		</form>
		
	</body>
</html>