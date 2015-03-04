<%@page contentType="text/html; charset=Windows-31J" %>

<HTML>

<BODY>

<H2>数字当てゲーム</H2>
(画面遷移バージョン)

<FORM ACTION="../servlet/GuessServlet">
<INPUT TYPE="text" name="number">
<INPUT TYPE="SUBMIT" VALUE="送信">
</FORM>

<%
String message =(String)request.getAttribute("message");
if(message != null){
	out.println(message);
}
%>

</BODY>
</HTML>
