<%@page contentType="text/html; charset=Windows-31J" %>

<HTML>
<HEAD>
<TITLE>サーブレットへのリンク</TITLE>
</HEAD>

<BODY>

<H2>サーブレットへのリンク</H2>

<P><A HREF="/entry/HelloServlet">HelloServlet</A>(カレントからのパス)

<P><A HREF="<%=request.getContextPath() %>/HelloServlet">HelloServlet</A>(サーバールートからのパス)
</BODY>
</HTML>