<%--
TLD
1. 在web-inf建立.tld檔
2.建立class，繼承:SimpleTagSupport、複寫:doTag()
3.在jsp指定taglib
--%>

<%--
JSTL
1.增加JSTL jar檔
2.在jsp指定taglib
3.使用 c:? + EL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mine" uri="https://onegztag" %><%--TLD--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--JSTL--%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<c:out value="Hello"/>

<mine:john id="A123" kind="${map}" >
    <table style="border:1px solid black;">
        <tr>
            <td>${msg}</td>
            <td>${counts}</td>
        </tr>
    </table>
</mine:john>
</body>
</html>

