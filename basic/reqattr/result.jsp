<%@page contentType="text/html; charset=Windows-31J" %>
<%@page import="reqattr.SampleBean" %>

<html>
<body>

<h2>�l�������Ƃ�JSP</h2>

<%
SampleBean bean = (SampleBean)request.getAttribute("bean");
String message = bean.getMessage();
out.println(message);
%>

</body>



</html>