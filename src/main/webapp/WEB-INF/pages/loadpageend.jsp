<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reiting</title>
</head>

<p>
<h2 align="center" style="color:#000000"> Мимимиметр </h2>
</p>

<p align="center"> <strong> Рейтинг результатов голосов!  ТОП 10 </strong>
</p>
<body>
<table border="2" >
    <p >
    <form action="/logautPage" method="get">

        <input type="submit" value="Выход"/>
    </form>
    </p>

</table>

<table align="center" valign="baseline" border="1">
                          <% int a=0; %>

       <tr>

                     <td align="center" valign="baseline">
                     <c:forEach  items="${requestScope.EndTableCat}" var="counter" >
                         <p>
                         <h1 align="left" > ${(a=a+1)}

                         <img style="overflow: scroll;height: 300px;width: 450px;" align="center" src= ${counter.getPicture()}>
                         <c:out value="${counter.getName_picture()}"> </c:out>


                         </h1>
                         </p>
                     </c:forEach>
                     </td>


       </tr>

</table>

<table border="2" >
    <p >
    <form action="/logautPage" method="get">

        <input type="submit" value="Выход"/>
    </form>
    </p>

</table>

</body>
</html>
