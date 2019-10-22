<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client</title>
</head>
<body>
<p >
<h3 align="center">    Зарегистрируйтесь.</h3>

</p>
<p>
   <h4 align="center">
        ${Message}
</h4>
</p>
<form action="${pageContext.request.contextPath}/user" method="post">

    <p align="center">
        Login: <input type="text"  name="userName" required/>
        Password: <input type="text"  name="userPassword" required>

        <input type="submit" value="ok"/>

    </p>

</form>

<form action="/logautPage" method="get">
    <p align="center">
        <input type="submit" value="Выход"/>
    </p>

</form>


</body>
</html>