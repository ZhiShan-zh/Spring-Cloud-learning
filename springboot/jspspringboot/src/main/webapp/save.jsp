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
	<form action="/hello/save" method="post">
		ID:<input type="text" name="id" /><br /> name:<input type="text"
			name="name" /><br /> age:<input type="text" name="age" /><br /> <input
			type="submit" value="提交" />
	</form>
</body>
</html>