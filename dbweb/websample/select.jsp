<%@page contentType="text/html; charset=Windows-31J" %>
<%@page import="java.util.List, websample.Account" %>

<html>
<body>

<table border="1">

<TR>
<TH>ID
<TH>NAME
<TH>MONEY

<%
	List<Account> list = (List<Account>)request.getAttribute("list");
	for(int i=0; i<list.size(); i++){
		Account account = list.get(i);
%>
		<TR>
			<TD><%=account.getId() %>
			<TD><%=account.getName() %>
			<TD><%=account.getMoney() %>
<%
	}
%>
</Table>

</body>
</html>