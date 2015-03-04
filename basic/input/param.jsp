<%@page contentType="text/html; charset=Windows-31J" %>

<HTML>

<BODY>

<H2>いろんなパラメータ</H2>

<FORM ACTION="../servlet/ParamListServlet">

<p>テキストフィールド
<INPUT TYPE="text" name="text1" VALUE="テキストフィールド">

<p>テキストエリア
<TEXTAREA NAME="textarea1" COLS="30" ROWS="5">テキストエリア</TEXTAREA>

<p>ラジオボタン
<INPUT TYPE="RADIO" name="radio1" VALUE="value1" CHECKED>左
<INPUT TYPE="RADIO" name="radio2" VALUE="value2">右

<p>チェックボックス
<INPUT TYPE="CHECKBOX" name="check1">ゴルフ
<INPUT TYPE="CHECKBOX" name="check2">テニス
<INPUT TYPE="CHECKBOX" name="check3">サッカー

<p>セレクト
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