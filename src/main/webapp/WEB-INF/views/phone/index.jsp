<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

			<table border="1" style="width:600px" align="center">
				<tr style="background-color:orange;height:30px">
					<th style="width:50px">Id</th>
					<th style="width:400px">Name</th>
					<th style="width:150px;text-align:center">Price</th>
				</tr>
				<c:forEach var="phone" items="${phoneList}">
				<tr style="height:30px">
					<td>${phone.id}</td>
					<td style="text-align:left;padding-left:10px">
						${phone.name}
					</td>
					<td>
						${phone.price}
					</td>
				</tr>
				</c:forEach>
					
			</table>

</body>
</html>