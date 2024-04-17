<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="login" method="post" modelAttribute="custObj">
username: <form:input path="username"/>
Address: <form:input path="address"/>
email:<form:input path="email"/>
<input type="submit"  value="LoginHere">
</form:form>
</body>
</html>