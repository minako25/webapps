<%@page contentType="text/html; charset=Windows-31J" %>
<H1>${param.name }‚Ìì¬</H1>

<FORM ACTION="create">
	<INPUT TYPE="HIDDEN" NAME="cmd" VALUE="create" >
	<INPUT TYPE="HIDDEN" NAME="name" VALUE="${param.name}" >

	<TEXTAREA ROWS="15" COLS="60" NAME="content"></TEXTAREA>

	<BR>
	<INPUT TYPE="submit" VALUE=" ì¬ ">
	<INPUT TYPE="button" VALUE=" ƒLƒƒƒ“ƒZƒ‹ " ONCLICK="location.href='refer'">

</FORM>