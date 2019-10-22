<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page1</title>
</head>
<body>

        <form name="f" action=<%=request.getContextPath()+"/login"%> method="post">
              <input type="text" name="username" value="test">
                 <input type="text" name="userpass" value="test">
                  <input type="submit" value="submit">

        </form>


</body>
</html>
