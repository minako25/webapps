package wiki;

import java.sql.Timestamp;

public class WikiPage {

	// DB WIKI_PAGEテーブルに対応するDTO

	/**
	 * ページの名前
	 */
	private String name;

	/**
	 * ページの内容
	 */
	private String content;

	/**
	 * 更新日時
	 */
	private Timestamp updateTime;

	/**
	 * 整形を行った内容を渡す
	 */
	public String getFormatedContent(){
		WikiFormater formater = new WikiFormater();
		return formater.formatText(content);
	}

	// ゲッタ・セッタ
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
