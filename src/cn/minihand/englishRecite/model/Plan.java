package cn.minihand.englishRecite.model;

import java.util.Date;

/**
 * 计划Model
 * @author Lingq
 *
 */
public class Plan {
	
	private int planId; //计划ID
	private int userId; //用户ID
	private String group; //分组
	private String days; //分天
	private String createTime; //创建时间
	private String isUse; //是否启用
	
	/*
	 * get方法
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
	 * set方法
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
