<%@page contentType="text/html; charset=Windows-31J" %>

<HTML>

<BODY>

<H2>�������ăQ�[��</H2>
(��ʑJ�ڃo�[�W����)

<FORM ACTION="../servlet/GuessServlet">
<INPUT TYPE="text" name="number">
<INPUT TYPE="SUBMIT" VALUE="���M">
</FORM>

<%
String message =(String)request.getAttribute("message");
if(message != null){
	out.println(message);
}
%>

</BODY>
</HTML>
