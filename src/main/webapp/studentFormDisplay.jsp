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
    <c:forEach var="form" items="${student.forms}">
        <c:if test="${form.reviewForm == true}">
            <tr>
                <td>${form.id}</td>
                <td><a href="${form.formUrl}">${form.name}</a></td>
                <td>${form.reviewDate}</td>
                <td>${form.reviewUserId}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>
