<%@page contentType="text/html; charset=Windows-31J" %>
<%@page import="java.util.*, el.User" %>
<!-- JSPページ内でタグライブラリを使う時の接頭辞を指定 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<h2>練習問題</h2>

<%
	// 準備
	List list = new ArrayList();
	list.add(new User("太郎", true));
	list.add(new User("次郎", true));
	list.add(new User("花子", false));
	request.setAttribute("list", list);
%>

<Table border="1">
<TR>
	<TH>番号
	<TH>名前
	<TH>性別
</TR>
<!-- 表示のためループを行う var:取り出した要素を格納する変数 items:ループを行うコレクション
varStatus:現在のループの状態を示す変数 -->
<c:forEach var="user" items="${ list }" varStatus="status">
	<TR>
	<TD>${status.index }
	<TD>${user.name }
	<TD>
		<c:choose>
			<c:when test="${user.male }">
				男
			</c:when>
			<c:otherwise>
				男以外
			</c:otherwise>
		</c:choose>
	</TR>
</c:forEach>

</Table>

</body>
</html>