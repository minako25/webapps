package wiki;

import java.sql.Timestamp;

public class WikiPage {

	// DB WIKI_PAGE�e�[�u���ɑΉ�����DTO

	/**
	 * �y�[�W�̖��O
	 */
	private String name;

	/**
	 * �y�[�W�̓��e
	 */
	private String content;

	/**
	 * �X�V����
	 */
	private Timestamp updateTime;

	/**
	 * ���`���s�������e��n��
	 */
	public String getFormatedContent(){
		WikiFormater formater = new WikiFormater();
		return formater.formatText(content);
	}

	// �Q�b�^�E�Z�b�^
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
