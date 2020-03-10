<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/hello/update" method="post">
		ID:<input type="text" name="id" value="${student.id}" readonly /><br />
		name:<input type="text" name="name" value="${student.name}" /><br />
		age:<input type="text" name="age" value="${student.age}" /><br /> <input
			type="submit" value="提交" />
	</form>
</body>
</html>