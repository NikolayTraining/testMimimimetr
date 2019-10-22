
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<p>
  <head>
    <title>Mimimimetr</title>
  </head>
  <p>
  <h1 align="center" style="color:Black"> Мимимиметр </h1>
  </p>

  <p> <h2 align="center"> Авторизуйтесь на сайте </h2>   </p>
<body>

<p align="center">  <h3> ${message}  </h3> </p>

    <table align="center">

        <tr>
            <p align="center">
            <form  name="f"  action="${pageContext.request.contextPath}/indexPage" method="post">
               <%-- <input type="hidden" name="_spring_security_remember_me" value="true">--%>
                <input type="text" name="userName" value="kk"/>
                <input type="text" name="userPassword" value="kk">
                <input type="submit" value="submit"/>

            </form>
            </p>

            <p>
                <%=request.getParameter("error")!=null ? request.getParameter("error"):"" %>
            </p>

        </tr>
        <p align="center">
        <form action="${pageContext.request.contextPath}/user" method="get">
            <input type="submit" value="new client"/>
        </form>
        </p>

    </table>






  </body>
</html>
