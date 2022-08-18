<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				姓名: <input type="text" id="username" name="username" value="John" required="required" />
				<p />
				<button type="submit" class="pure-button pure-button-primary">電腦選號</button>
			</fieldset>
		</form>
		<form class="pure-form">
			<fieldset>
				<legend>Lotto list</legend>
				原始資料: ${ lottos } <p />
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th rowspan="2" valign="middle">序號</th>
							<th colspan="4" align="center">號碼</th>
						</tr>
						<tr>
							<th>一</th>
							<th>二</th>
							<th>三</th>
							<th>四</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach varStatus="status" var="num" items="${ lottos }">
							<tr>
								<td>${ status.index }</td>
								<c:forEach var="n" items="${ num }">
									<td>${ n }</td>
								</c:forEach>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</fieldset>
		</form>
	</body>
</html>