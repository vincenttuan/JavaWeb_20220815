<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>Book form</title>
	</head>
	<body style="padding: 15px">
		<form class="pure-form" method="post" action="${ pageContext.request.contextPath }/mvc/book/">
			<fieldset>
				<legend>Book form</legend>
				序號: <input type="text" value="${ requestScope.book.id }" id="id" name="id" readonly="readonly" /><p />  
				書名: <input type="text" value="${ requestScope.book.name }" id="name" name="name" /><p />
				數量: <input type="number" value="${ requestScope.book.amount }" id="amount" name="amount" /><p />
				價格: <input type="number" value="${ requestScope.book.price }" id="price" name="price" /><p />
				填表人ID: ${ sessionScope.user.id }<p />
				填表人: ${ sessionScope.user.username }<p />
				<button type="submit" class="pure-button pure-button-primary">${ requestScope.buttonName }</button> 
			</fieldset>
		</form>
		<form class="pure-form">
			<fieldset>
				<legend>Book List</legend>
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>序號</th><th>書名</th><th>數量</th><th>價格</th><th>填表人ID</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${ requestScope.books }">
						<tr>
							<td>${ book.id }</td>
							<td>${ book.name }</td>
							<td>${ book.amount }</td>
							<td>${ book.price }</td>
							<td>${ book.userId }</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</fieldset>
		</form>
	</body>
</html>