package cn.minihand.englishRecite.model;

import java.util.Date;

/**
 * 考试Model
 * @author Lingq
 *
 */
public class Exam {

	private int examId; //考试Id
	private int userId; //用户Id
	private String createTime; //考试时间
	private String examContent; //存放内容ID，多个ID间用逗号隔开 
	private String correctContent; //存放正确内容的ID，多个ID间用逗号隔开
	private String failContent; //存放错误内容的ID，多个ID间用逗号隔开
	private String emptyContent; //存放未填写内容的ID，多个ID间用逗号隔开
	
	/*
	 * get方法
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
	 * set方法
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
