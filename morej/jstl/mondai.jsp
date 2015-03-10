<%@page contentType="text/html; charset=Windows-31J" %>
<%@page import="java.util.*, el.User" %>
<!-- JSP�y�[�W���Ń^�O���C�u�������g�����̐ړ������w�� -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<h2>���K���</h2>

<%
	// ����
	List list = new ArrayList();
	list.add(new User("���Y", true));
	list.add(new User("���Y", true));
	list.add(new User("�Ԏq", false));
	request.setAttribute("list", list);
%>

<Table border="1">
<TR>
	<TH>�ԍ�
	<TH>���O
	<TH>����
</TR>
<!-- �\���̂��߃��[�v���s�� var:���o�����v�f���i�[����ϐ� items:���[�v���s���R���N�V����
varStatus:���݂̃��[�v�̏�Ԃ������ϐ� -->
<c:forEach var="user" items="${ list }" varStatus="status">
	<TR>
	<TD>${status.index }
	<TD>${user.name }
	<TD>
		<c:choose>
			<c:when test="${user.male }">
				�j
			</c:when>
			<c:otherwise>
				�j�ȊO
			</c:otherwise>
		</c:choose>
	</TR>
</c:forEach>

</Table>

</body>
</html>