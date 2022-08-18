<%@ page import="java.util.List"%>
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
				<button type="submit" class="pure-button">返回</button>
			</fieldset>
		</form>
		<form class="pure-form">
			<fieldset>
				<legend>Lotto list</legend>
				原始資料: ${ lottos } <p />
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>序號</th>
							<th>號碼</th>
						</tr>
					</thead>
					<tbody>
						<% List<List<Integer>> list = (List<List<Integer>>)request.getAttribute("lottos"); %>
						<% for(int i=0;i<list.size();i++) {  %>
							<tr>
								<td><%=i %></td>
								<td><%=list.get(i) %></td>
							</tr>
						<% } %>
					</tbody>
				</table>
			</fieldset>
		</form>
	</body>
</html>