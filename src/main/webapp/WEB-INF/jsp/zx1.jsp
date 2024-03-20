<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
(轉頁測試)zx1.jsp

<!--
STEP1
webapp/WEB-INF
-->

<!--
STEP2
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
-->

<!-- pom.xml JSP
STEP3
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
</dependency>
-->


<form name="form1" id="form1" action="/zx1/zx1_method2/100" method="post" >
    <input type="text" id="user" value="${user}">
    <input type="submit" id="btn"  value="按鈕" >
</form>


<%
    session.setAttribute("carID" , "1");
%>
</body>
</html>