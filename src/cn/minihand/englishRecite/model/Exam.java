package cn.minihand.englishRecite.model;

import java.util.Date;

/**
 * ����Model
 * @author Lingq
 *
 */
public class Exam {

	private int examId; //����Id
	private int userId; //�û�Id
	private String createTime; //����ʱ��
	private String examContent; //�������ID�����ID���ö��Ÿ��� 
	private String correctContent; //�����ȷ���ݵ�ID�����ID���ö��Ÿ���
	private String failContent; //��Ŵ������ݵ�ID�����ID���ö��Ÿ���
	private String emptyContent; //���δ��д���ݵ�ID�����ID���ö��Ÿ���
	
	/*
	 * get����
	 */
	public int getExamId() {
		return examId;
	}
	public int getUserId() {
		return userId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public String getExamContent() {
		return examContent;
	}
	public String getCorrectContent() {
		return correctContent;
	}
	public String getFailContent() {
		return failContent;
	}
	public String getEmptyContent() {
		return emptyContent;
	}
	
	/*
	 * set����
	 */
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public void setExamContent(String examContent) {
		this.examContent = examContent;
	}
	public void setCorrectContent(String correctContent) {
		this.correctContent = correctContent;
	}
	public void setFailContent(String failContent) {
		this.failContent = failContent;
	}
	public void setEmptyContent(String emptyContent) {
		this.emptyContent = emptyContent;
	}
}
