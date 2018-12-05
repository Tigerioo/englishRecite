package cn.minihand.englishRecite.model;

import java.util.Date;

/**
 * ����Model
 * @author Lingq
 *
 */
public class Recite {

	private int reciteId; //����ID
	private int userId; //�û�ID
	private String createTime; //����ʱ��
	private String updateTime; //����ʱ��
	private String star; //�Ǳ�
	private int contentId; //����ID
	private int reciteTime; //���д���
	private int failTime; //ʧ�ܴ���
	private String isLearned; //�Ƿ�ͨ��
	
	/*
	 * get����
	 */
	public int getReciteId() {
		return reciteId;
	}
	public int getUserId() {
		return userId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public String getStar() {
		return star;
	}
	public int getContentId() {
		return contentId;
	}
	public int getReciteTime() {
		return reciteTime;
	}
	public int getFailTime() {
		return failTime;
	}
	public String getIsLearned() {
		return isLearned;
	}
	
	/*
	 * set����
	 */
	public void setReciteId(int reciteId) {
		this.reciteId = reciteId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public void setReciteTime(int reciteTime) {
		this.reciteTime = reciteTime;
	}
	public void setFailTime(int failTime) {
		this.failTime = failTime;
	}
	public void setIsLearned(String isLearned) {
		this.isLearned = isLearned;
	}
}
