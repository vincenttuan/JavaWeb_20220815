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
		<form class="pure-form" method="post" action="${ pageContext.request.contextPath }/mvc/user/">
			<fieldset>
				<legend>User Form</legend>
				序號: <input type="text" value="${ user.id }" id="id" name="id" readonly="readonly" /><p />
				帳號: <input type="text" value="${ user.username }" id="username" name="username" placeholder="請輸入 username" required="required" /><p />
				密碼: <input type="text" value="" id="password" name="password" placeholder="請輸入 password" required="required" /><p />
				薪資: <input type="text" value="${ user.salaryDecrypt }" id="salary" name="salary" placeholder="請輸入 salary" required="required" /><p />
				<button type="submit" class="pure-button pure-button-primary">${ buttonName }</button>
				<button type="button" onclick="location.href='${ pageContext.request.contextPath }/mvc/user/';" class="pure-button pure-button-primary">取消</button>
			</fieldset>
		</form>
		<form class="pure-form">
			<fieldset>
				<legend>User List</legend>
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>序號</th><th>帳號</th><th>密碼(加密)</th><th>薪資(加密)</th><th>薪資(解密)</th><th>建立時間</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${ users }">
						<tr>
							<td>
								<a href="${ pageContext.request.contextPath }/mvc/user/${ user.id }">
									${ user.id }
								</a>
							</td>
							<td>${ user.username }</td>
							<td>${ user.password }</td>
							<td>${ user.salary }</td>
							<td>${ user.salaryDecrypt }</td>
							<td>${ user.createtime }</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</fieldset>
		</form>
		
	</body>
</html>