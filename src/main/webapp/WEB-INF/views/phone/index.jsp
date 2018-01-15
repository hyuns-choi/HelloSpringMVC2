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
<script type="text/javascript">
	function onProcess(mode, id, name, price){
		
		document.form1.mode.value = mode;
		document.form1.idx.value = id;
		document.form1.name.value = name;
		document.form1.price.value = price;		
		document.form1.submit1.value = mode;
		
		if(mode == "del"){
			 document.form1.submit1.click();
		}		
	}
</script>

<h1>JPA Sample</h1>
<table>
	<form name="form1" method="post" action="phone">
	<input type="hidden" id="mode" name="mode" value="insert">
	<input type="hidden" id="idx" name="idx" value="0">
		<tr><td>Name: </td><td><input type="text" id="name" name="name"></td></tr>
		<tr><td>Price: </td><td><input type="text" id="price" name="price"></td></tr>
		<tr><td></td><td><input type="submit" name="submit1" id="submit1" value="추가"></td></tr>
	
	</form>
</table>

			<table border="1" style="width:600px" >
				<tr style="background-color:orange;height:30px">
					<th style="width:50px">Id</th>
					<th style="width:300px">Name</th>
					<th style="width:150px;text-align:center">Price</th>
					<th style="width:100px">처리</th>
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
					<td>
					<input type="button" value="수정" onclick="onProcess('edit', '${phone.id}', '${phone.name}', '${phone.price}');" >
					<input type="button" value="삭제" onclick="onProcess('del', '${phone.id}', '${phone.name}', '${phone.price}');" >
						
					</td>
				</tr>
				</c:forEach>
					
			</table>

</body>
</html>