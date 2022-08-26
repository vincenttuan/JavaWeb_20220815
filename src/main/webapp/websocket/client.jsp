<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>WebSocket Client</title>
		<script type="text/javascript">
			var webSocket = null;
			// 網頁載入成功
			window.onload = function() {
				conn_button.disabled = false;
				close_button.disabled = true;
				send_button.disabled = true;
				// 按下 conn_button
				conn_button.addEventListener("click", function() {
					setWebSocket();
				});
				// 按下 close_button
				close_button.addEventListener("click", function() {
					if(webSocket != null) {
						webSocket.close();
						webSocket = null;
					}
				});
				// 按下 send_button
				send_button.addEventListener("click", function() {
					sendMessage();
				});
			};
			
			// 設置 websocket
			function setWebSocket() {
				
			}
			
			// 傳送訊息
			function sendMessage() {
				
			}
			
			
		</script>
	</head>
	<body>
		<body style="padding: 15px">
			<%@ include file="/WEB-INF/view/menu.jspf" %>
			<form class="pure-form">
				<fieldset>
					<legend>WebSocket Client</legend>
					姓名: ${ sessionScope.user.username }
					<button type="button" class="pure-button pure-button-primary" id="conn_button">連線</button>
					<button type="button" class="pure-button pure-button-primary" id="close_button">關閉</button>
					<p />
					訊息: <input type="text" id="message" name="message" placeholder="請輸入訊息" required="required" />
					<button type="button" class="pure-button pure-button-primary" id="send_button">傳送</button>
				</fieldset>
			</form>
			<div id="message_display"></div>
		</body>
		
	</body>
</html>