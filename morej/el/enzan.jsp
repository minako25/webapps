<%@page contentType="text/html; charset=Windows-31J" %>
<%@page import="java.util.*" %>

<html>
<body>

<h2>ELのテスト</h2>

<!-- 集合や配列の要素へのアクセス -->
<%
	// 準備
	List list = new ArrayList();
	request.setAttribute("list", list);
%>

<pre>
${ 1 + 2 }

${ 1 < 2 }

${ true && false }

${ 1 < 2 ? 2 : 1 }

${ empty list }
</pre>
</body>
</html>