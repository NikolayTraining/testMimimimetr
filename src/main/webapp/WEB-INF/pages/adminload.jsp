<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Picture</title>
</head>
<body>
<p align="center"> <strong> Загрузка фотографий.  </strong>
</p>

${message2}
<c:form  action="/upload" method="post" enctype="multipart/form-data">

    <p>
        Введите имя картинки: <input type="text" name="description" required/>
    </p><p>
    <input  type="file" name="file" />
    </p>
    <input type="submit" />
</c:form>

</body>
</html>
