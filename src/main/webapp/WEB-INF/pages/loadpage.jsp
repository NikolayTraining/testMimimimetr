
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page</title>
</head>
<p>
<h2 align="center" style="color:#000000"> Мимимиметр </h2>
</p>

<h3 align="center"> <strong> Кто из них мимимишнее? </strong> </h3>
<p align="center"> <strong> Проголосуйте за понравившуюся картинку! </strong>
</p>
<p align="center"> <strong>  Кликни по фотографии или названию! </strong>
</p>
<body>


<table border="1" align="center">

               <td align="center">
                    <p>
                   <form   action="/loadPage" method="post">
                   <button name="Button1">
                       <img style="overflow: scroll;height: 300px;width: 450px;" src=${outPicture1}>
                   </button>
                     </form>
                     </p>
                   <p align="center">
                   <form   action="/loadPage" method="post">

                       <input name="Button2" alt="Button2" type="submit" value="Кличка: ${outName1}"/>
                   </form>

                   </p>


              </td>
               <td align="center">
                   <p>
                   <form   action="/loadPage" method="post">
                   <button name="Button3">
                       <img style="overflow: scroll;height: 300px;width: 450px;" src=${outPicture2}>
                   </button>

                   </form>
                   </p>
                   <p align="center">
                   <form  action="/loadPage" method="post">

                       <input name="Button4" type="submit" value="Кличка: ${outName2}"/>
                   </form>

                   </p>

               </td>


    <p align="center">
    <form action="/loadPage" method="post">

        <input type="submit" value="Следующая пара"/>
    </form>

    </p>


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
