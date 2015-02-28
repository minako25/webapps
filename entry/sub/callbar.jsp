<%@page contentType="text/html; charset=Windows-31J" %>

<HTML>
<HEAD>
<TITLE>練習問題</TITLE>
</HEAD>

<BODY>

<H2>BarServletへのリンク</H2>

<P><A HREF="/entry/BarServlet">BarServlet</A>(カレントからのパス)

<P><A HREF="<%=request.getContextPath() %>/BarServlet">BarServlet</A>(サーバールートからのパス)
</BODY>
</HTML>