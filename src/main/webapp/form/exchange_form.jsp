<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>Exchange</title>
	</head>
	<body style="padding: 15px">
		
		<form class="pure-form" method="post" action="/JavaWeb_20220815/servlet/exchange">
			<fieldset>
				<legend>Exchange 換匯</legend>
				台幣: <input type="number" id="amount" name="amount" placeholder="請輸入金額" required="required"><p />
				兌換: <input type="radio" id="currency" name="currency" value="USD" />美金&nbsp;
					 <input type="radio" id="currency" name="currency" value="JPY" />日幣&nbsp;
					 <input type="radio" id="currency" name="currency" value="CNY" />人民幣&nbsp;
					 <input type="radio" id="currency" name="currency" value="EUR" />歐元&nbsp;
					 <p />
				<button type="reset" class="pure-button">清除</button>
				<button type="submit" class="pure-button pure-button-primary">傳送</button>
			</fieldset>
		</form>
		<p />
		<form class="pure-form">
			<fieldset>
				<legend>Exchange 結果</legend>
				台幣: ${ amount }<p />
				兌換: $${ currency } ${ result }<p />
			</fieldset>
		</form>
		
	</body>
</html>