<%@page contentType="text/html; charset=Windows-31J" %>
<h1>�y�[�W�̈ꗗ</h1>

<c:forEach var="wikiPage" items="${list }">
	<c:url value="/refer" var="url">
		<c:param name="name" value="${wikiPage.name }"></c:param>
	</c:url>
	<li><A href="${url}">${wikiPage.name}</A><BR>
</c:forEach>