package cn.minihand.englishRecite.model;

/**
 * ����Model
 * @author lingq
 *
 */
public class Content {
	
	private int contentId; // ����Id
	private String chinese; //����
	private String english; //Ӣ��
	private String voice; //�����Ƶ��·��
	private String type; //���ͣ�������ӡ�����

	/*
	 * get����
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
	 * set����
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
