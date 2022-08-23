<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>Book form</title>
		<script>
			function submitForm() {
				var id = document.getElementById("id").value;
				
				if(id == '') { // 表示是新增模式
					return true;
				}
				
				// 修改 PUT 需透過 Javscript/Ajax 將資料送到後台
				var name = document.getElementById("name").value;
				var amount = document.getElementById("amount").value;
				var price = document.getElementById("price").value;
				var updateUrl = '${ pageContext.request.contextPath }/mvc/book/' + id;
				//var fd = new FormData(document.getElementById('bookForm'));
				var fd = 'id='+id+'&name='+name+'&amount='+amount+'&price='+price;
				console.log(fd);
				console.log(updateUrl);
				
				return false;
			}
		</script>
	</head>
	<body style="padding: 15px">
		<form id="bookForm" class="pure-form" onsubmit="return submitForm();" method="post" action="${ pageContext.request.contextPath }/mvc/book/">
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
							<td>
								<a href="${ pageContext.request.contextPath }/mvc/book/${ book.id }">
									${ book.id }
								</a>
							</td>
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