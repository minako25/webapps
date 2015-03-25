<%@page contentType="text/html; charset=Windows-31J" %>
<H1>${wikiPage.name }の編集</H1>

<FORM ACTION="update">
	<INPUT TYPE="HIDDEN" NAME="cmd" VALUE="update" >
	<INPUT TYPE="HIDDEN" NAME="name" VALUE="${wikiPage.name}" >

	<TEXTAREA ROWS="15" COLS="60" NAME="content">${wikiPage.content}</TEXTAREA>

	<BR>
	<INPUT TYPE="submit" VALUE=" 更新 ">
	<INPUT TYPE="submit" VALUE=" 削除 " ONCLICK="cmd.value='delete'">
	<INPUT TYPE="button" VALUE=" キャンセル " ONCLICK="location.href='refer'">

</FORM>