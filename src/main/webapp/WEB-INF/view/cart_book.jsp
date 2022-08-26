<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>Cart 購物車</title>
		
	</head>
	<body style="padding: 15px">
		<div class="pure-form">
			<fieldset>
				<legend>
					${ sessionScope.user.username } 的購物車(Cart)資料
					|
					<a href="${ pageContext.request.contextPath }/mvc/buy/book/">繼續購物</a>
				</legend>
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>序號</th><th>書號</th><th>購買數量</th><th>小計</th><th>購買時間</th><th>刪除</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cart" items="${ requestScope.carts }">
							<tr>
								<td>${ cart.id }</td>
								<td>${ cart.bookId }</td>
								<td>${ cart.qty }</td>
								<td>${ cart.subtotal }</td>
								<td>${ cart.createtime }</td>
								<td>
									<button type="button" class="pure-button pure-button-primary">
										刪除
									</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</fieldset>
		</div>
	</body>
</html>