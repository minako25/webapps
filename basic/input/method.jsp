<%@page contentType="text/html; charset=Windows-31J" %>

<HTML>

<BODY>

<H2>MethodServletの入力</H2>

<A HREF="../servlet/MethodServlet?message=hello">リンクでGET送信</A>
<FORM ACTION="../servlet/MethodServlet" METHOD="GET">
<INPUT TYPE="text" name="message">
<INPUT TYPE="SUBMIT" VALUE="フォームでGET送信">
</FORM>

<FORM ACTION="../servlet/MethodServlet" METHOD="POST">
<INPUT TYPE="text" name="message">
<INPUT TYPE="SUBMIT" VALUE="フォームでPOST送信">
</FORM>

</BODY>
</HTML>