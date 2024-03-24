<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
登入成功
<form name="form1" id="form1" action="/checkIt/c301" >
    ${user.username}<br>
    ${user.pwd}<br>
    ${user.pwd2}<br>
    <input type="submit" value="返回" /><br>
</form>
</body>
</html>