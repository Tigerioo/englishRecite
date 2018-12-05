package cn.minihand.englishRecite.model;

import java.util.Date;

/**
 * 用户Model
 * @author Lingq
 *
 */
public class User {

	private int user_id; //用户ID
	private String username; //username
	private String password; //password
	private String records; //学习记录,存放ID，用逗号隔开
	private String plans; //学习计划,存放ID，用逗号隔开
	private String exams; //考试，存放ID，用逗号隔开
	private String last_study_time; //上次学习时间(上次登录时间)
	private String friends; //好友列表
	private String isOnline; //是否在线
	private String onlineIpAddress; //当前在线的IP地址
	
	/*
	 * get方法
	 */
	public int getUser_id() {
		return user_id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRecords() {
		return records;
	}

	public String getPlans() {
		return plans;
	}

	public String getExams() {
		return exams;
	}

	public String getLast_study_time() {
		return last_study_time;
	}

	public String getFriends() {
		return friends;
	}
	
	public String getIsOnline() {
		return isOnline;
	}
	
	public String getOnlineIpAddress() {
		return onlineIpAddress;
	}
	/*
	 * set方法
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRecords(String records) {
		this.records = records;
	}

	public void setPlans(String plans) {
		this.plans = plans;
	}

	public void setExams(String exams) {
		this.exams = exams;
	}

	public void setLast_study_time(String last_study_time) {
		this.last_study_time = last_study_time;
	}

	public void setFriends(String friends) {
		this.friends = friends;
	}

	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}

	public void setOnlineIpAddress(String onlineIpAddress) {
		this.onlineIpAddress = onlineIpAddress;
	}

}
