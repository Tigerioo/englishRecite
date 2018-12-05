package cn.minihand.englishRecite.model;

/**
 * 内容Model
 * @author lingq
 *
 */
public class Content {
	
	private int contentId; // 内容Id
	private String chinese; //中文
	private String english; //英文
	private String voice; //存放音频的路径
	private String type; //类型，短语、句子、段落

	/*
	 * get方法
	 */
	public int getContentId() {
		return contentId;
	}

	public String getChinese() {
		return chinese;
	}

	public String getEnglish() {
		return english;
	}

	public String getVoice() {
		return voice;
	}

	public String getType() {
		return type;
	}

	/*
	 * set方法
	 */
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public void setChinese(String chinese) {
		this.chinese = chinese;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
