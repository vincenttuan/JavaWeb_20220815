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
				// websocket server 端 url
				var url = 'ws://' + window.location.hostname + ':8080${ pageContext.request.contextPath }/websocket';
				// 建立 WebSocket 連線
				webSocket = new WebSocket(url);
				// 以下就可以操作各種 WebSocket 事件
				webSocket.onopen = function(event) { // 連線成功
					console.log('連線成功');
					conn_button.disabled = true;
					close_button.disabled = false;
					send_button.disabled = false;
				}
				webSocket.onclose = function(event) { // 連線關閉
					console.log('連線關閉');
					conn_button.disabled = false;
					close_button.disabled = true;
					send_button.disabled = true;
				}
				webSocket.onmessage = function(event) { // 接收訊息
					var msg = event.data;
					console.log('接收訊息: ' + msg);
					message_display.insertAdjacentHTML('afterbegin', msg + '<br />');
				}
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