<%@include file="head.jsp"%>
<html>
<body>
<div class="container-fluid" align="center">

    <h2>User Display Exercise - Week 1</h2>
    <p><%out.println("Your IP address is " + request.getRemoteAddr());%></p>
<%--    <p>Today's date: <%= (new java.util.Date()) %></p> --%>
    <p>
        <c:out value="Today's Local Date & Time: ${date}"/>
        <%--TODO How can this be done using JSTL???--%>
        <%= java.time.LocalDateTime.now().toString() %>
    </p>
    <%--
    <a href="searchUser">Go to the User Search</a>
    --%>
    <br />
    <form action="searchUser" method="get">
        <input type="text" name="inputLast" value="Tillman">
        <input type="submit" value="Search">
    </form>
</div>
</body>
</html>
