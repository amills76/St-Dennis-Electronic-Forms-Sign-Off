<%--
  Created by IntelliJ IDEA.
  User: Andy Mills
  Date: 9/21/16
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>St Dennis Student Registration Forms</title>
</head>
<body>
    <table align="center">
    <c:forEach var="student" items="${parent.students}">
        <c:if test="${student.reviewForms == true}">
        <tr>
            <td>${student.firstName}</td>
            <td>${student.lastName}</td>
            <td>${student.Grade}</td>
            <td>${student.review}</td>
            <td><a href="formDisplay">Review Forms</a></td>
        </tr>
        </c:if>
    </c:forEach>
    </table>
</body>
</html>
