<%@include file="head.jsp"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<html>
<body>

<%--TODO Pretty up the results!--%>
<div class="container-fluid" align="center">

    <h2>Search Results: </h2>
    <br />
<%--    <table border="1" cellpadding="5"> --%>
    <table> <%-- table style added to head.jsp --%>
        <tr>
            <th><c:out value=" User ID "/></th>
            <th><c:out value="${' First Name '}"/></th>
            <th> Last Name </th>
            <th> Age </th>
        </tr>
        <c:forEach var="user" items="${users}">
        <tr>
            <td><c:out value="${user.getUserid()}"    /></td>
            <td><c:out value="${user.getFirstName()}" /></td>
            <td><c:out value="${user.getLastName()}"  /></td>
            <td><c:out value="${user.getAge()}"       /></td>
        </tr>
        </c:forEach>
    </table>
    <br />
    <a href="index.jsp">Home</a>

</div>

</body>
</html>
