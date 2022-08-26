<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>Buy Book form</title>
		
	</head>
	<body style="padding: 15px">
		<div class="pure-form">
			<fieldset>
				<legend>
					${ sessionScope.user.username } 您好! Buy Book List
					|
					<a href="${ pageContext.request.contextPath }/mvc/cart/book/">查看購物車</a>
				</legend>
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>序號</th><th>書名</th><th>數量</th><th>價格</th><th>購買數量</th><th>購買</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${ requestScope.books }">
							<form method="post" action="${ pageContext.request.contextPath }/mvc/buy/book/">
								<tr>
									<td>
										<input type="hidden" value="${ book.id }" id="book_id" name="book_id" />
										${ book.id }
									</td>
									<td>${ book.name }</td>
									<td>${ book.amount }</td>
									<td>${ book.price }</td>
									<td>
										<input type="number" id="qty" name="qty" required="required" />
									</td>
									<td>
										<button type="submit" class="pure-button pure-button-primary">
											購買
										</button>
									</td>
								</tr>
							</form>
						</c:forEach>
					</tbody>
				</table>
			</fieldset>
		</div>
	</body>
</html>