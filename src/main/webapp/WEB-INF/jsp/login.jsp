<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Example</title>
</head>
<body>
<h1>PetClinic Login Page </h1>
<form action="login" method="POST">
    Username: <input type="text" name="username"> <br><br>
    Password: <input type="password" name="password"><br><br>
    Remember me: <input type="checkbox" name="remember-me"><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <br><br>
    <input type="submit" value="Login"/>
    <font color="red">
        <c:if test="${not empty param.loginFailed}">
            <c:out value="Login Failed, Incorrect Username or Password"></c:out>
        </c:if>
    </font>
</form>
</body>
</html>