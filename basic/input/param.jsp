<%@page contentType="text/html; charset=Windows-31J" %>

<HTML>

<BODY>

<H2>�����ȃp�����[�^</H2>

<FORM ACTION="../servlet/ParamListServlet">

<p>�e�L�X�g�t�B�[���h
<INPUT TYPE="text" name="text1" VALUE="�e�L�X�g�t�B�[���h">

<p>�e�L�X�g�G���A
<TEXTAREA NAME="textarea1" COLS="30" ROWS="5">�e�L�X�g�G���A</TEXTAREA>

<p>���W�I�{�^��
<INPUT TYPE="RADIO" name="radio1" VALUE="value1" CHECKED>��
<INPUT TYPE="RADIO" name="radio2" VALUE="value2">�E

<p>�`�F�b�N�{�b�N�X
<INPUT TYPE="CHECKBOX" name="check1">�S���t
<INPUT TYPE="CHECKBOX" name="check2">�e�j�X
<INPUT TYPE="CHECKBOX" name="check3">�T�b�J�[

<p>�Z���N�g
<select NAME="lang" SIZE="3" MULTIPLE="true">
<OPTION VALUE="sel1">VB
<OPTION VALUE="sel2">C
<OPTION VALUE="sel3">Java
</select>


	<P>
	<INPUT TYPE="SUBMIT">
	<INPUT TYPE="RESET">
</FORM>



</BODY>
</HTML>