package cn.minihand.englishRecite.model;

import java.util.Date;

/**
 * �û�Model
 * @author Lingq
 *
 */
public class User {

	private int user_id; //�û�ID
	private String username; //username
	private String password; //password
	private String records; //ѧϰ��¼,���ID���ö��Ÿ���
	private String plans; //ѧϰ�ƻ�,���ID���ö��Ÿ���
	private String exams; //���ԣ����ID���ö��Ÿ���
	private String last_study_time; //�ϴ�ѧϰʱ��(�ϴε�¼ʱ��)
	private String friends; //�����б�
	private String isOnline; //�Ƿ�����
	private String onlineIpAddress; //��ǰ���ߵ�IP��ַ
	
	/*
	 * get����
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
	 * set����
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
