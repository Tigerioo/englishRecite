package cn.minihand.englishRecite.model;

import java.util.Date;

/**
 * �ƻ�Model
 * @author Lingq
 *
 */
public class Plan {
	
	private int planId; //�ƻ�ID
	private int userId; //�û�ID
	private String group; //����
	private String days; //����
	private String createTime; //����ʱ��
	private String isUse; //�Ƿ�����
	
	/*
	 * get����
	 */
	public int getPlanId() {
		return planId;
	}
	public int getUserId() {
		return userId;
	}
	public String getGroup() {
		return group;
	}
	public String getDays() {
		return days;
	}
	public String getCreateTime() {
		return createTime;
	}
	public String getIsUse() {
		return isUse;
	}
	
	/*
	 * set����
	 */
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}
}
