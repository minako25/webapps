<%@page contentType="text/html; charset=Windows-31J" %>

<HTML>

<BODY>

<H2>MethodServlet�̓���</H2>

<A HREF="../servlet/MethodServlet?message=hello">�����N��GET���M</A>
<FORM ACTION="../servlet/MethodServlet" METHOD="GET">
<INPUT TYPE="text" name="message">
<INPUT TYPE="SUBMIT" VALUE="�t�H�[����GET���M">
</FORM>

<FORM ACTION="../servlet/MethodServlet" METHOD="POST">
<INPUT TYPE="text" name="message">
<INPUT TYPE="SUBMIT" VALUE="�t�H�[����POST���M">
</FORM>

</BODY>
</HTML>