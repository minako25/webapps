<%@page contentType="text/html; charset=Windows-31J" %>

<html>
<body>

<h2>‘å“–‚½‚è</h2>

<%
String message =(String)request.getAttribute("message");
if(message != null){
	out.println(message);
}
%>

</body>



</html>