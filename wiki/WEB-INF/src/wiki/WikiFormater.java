package wiki;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WikiFormater {
	// Wikiの表示を整形するためのクラス
	public String formatText(String text){

		text = escapeHtmlTags(text);
		text = createHyperLink(text);
		text = addBrToEachLines(text);
		return text;
	}

	//<BR>タグの追加
	private String addBrToEachLines(String text){

		text = text.replaceAll("[\n]", "<BR>\n");	// 指定した文字列に一致する文字を置換する
		return text;
	}

	//<、>、タブの変換
	private String escapeHtmlTags(String text){

		text = text.replaceAll("<", "&lt");
		text = text.replaceAll(">", "&gt");
		text = text.replaceAll("\t", "  ");
		return text;
	}

	// リンクの生成
	private String createHyperLink(String text){
		Pattern patten = Pattern.compile("(mailto|http|https|ftp):\\/\\/([^\\s]+)");
		Matcher matcher = patten.matcher(text);
		StringBuffer sb = new StringBuffer();

		while(matcher.find()){
			String group = matcher.group();
			String repText = "<A HREF=\"" + group + "\">" + group + "</A>";
			matcher.appendReplacement(sb, repText);
		}
		matcher.appendTail(sb);
		return sb.toString();
	}
}
