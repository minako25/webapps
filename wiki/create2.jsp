<%@page contentType="text/html; charset=Windows-31J" %>
<H1>${param.name }�̍쐬</H1>

<FORM ACTION="create">
	<INPUT TYPE="HIDDEN" NAME="cmd" VALUE="create" >
	<INPUT TYPE="HIDDEN" NAME="name" VALUE="${param.name}" >

	<TEXTAREA ROWS="15" COLS="60" NAME="content"></TEXTAREA>

	<BR>
	<INPUT TYPE="submit" VALUE=" �쐬 ">
	<INPUT TYPE="button" VALUE=" �L�����Z�� " ONCLICK="location.href='refer'">

</FORM>