<%--
  Created by IntelliJ IDEA.
  User: Win10
  Date: 7/2/2019
  Time: 5:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr style="font-weight: bold" bgcolor="#add8e6">
        <td>ID</td>
        <td>FirstName</td>
        <td>LastName</td>
    </tr>
    </thead>


    <c:forEach items="${owners}" var="owner" varStatus="status">
        <tr bgcolor=${status.index % 2 ==0 ? 'white':'lightgray'}>
            <td>${owner.id}</td>
            <td>${owner.firstName}</td>
            <td>${owner.lastName}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
