<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>User form</title>
	</head>
	<body style="padding: 15px">
		<form class="pure-form" method="psot" action="${ pageContext.request.contextPath }/mvc/user">
			<fieldset>
				<legend>User Form</legend>
				id: <input type="text" id="id" name="id" readonly="readonly" /><p />
				username: <input type="text" id="username" name="username" placeholder="請輸入 username" required="required" /><p />
				password: <input type="text" id="password" name="password" placeholder="請輸入 password" required="required" /><p />
				salary: <input type="text" id="salary" name="salary" placeholder="請輸入 salary" required="required" /><p />
				<button type="submit" class="pure-button pure-button-primary">新增</button>
			</fieldset>
		</form>
		<form class="pure-form">
			<fieldset>
				<legend>User List</legend>
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>id</th><th>username</th><th>password</th><th>salary</th><th>createtime</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${ users }">
						<tr>
							<td>${ user.id }</td>
							<td>${ user.username }</td>
							<td>${ user.password }</td>
							<td>${ user.salary }</td>
							<td>${ user.createtime }</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</fieldset>
		</form>
		
	</body>
</html>