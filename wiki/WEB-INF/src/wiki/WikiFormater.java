package wiki;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WikiFormater {
	// Wiki�̕\���𐮌`���邽�߂̃N���X
	public String formatText(String text){

		text = escapeHtmlTags(text);
		text = createHyperLink(text);
		text = addBrToEachLines(text);
		return text;
	}

	//<BR>�^�O�̒ǉ�
	private String addBrToEachLines(String text){

		text = text.replaceAll("[\n]", "<BR>\n");	// �w�肵��������Ɉ�v���镶����u������
		return text;
	}

	//<�A>�A�^�u�̕ϊ�
	private String escapeHtmlTags(String text){

		text = text.replaceAll("<", "&lt");
		text = text.replaceAll(">", "&gt");
		text = text.replaceAll("\t", "  ");
		return text;
	}

	// �����N�̐���
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
