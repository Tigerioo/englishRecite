package cn.minihand.englishRecite.model;

/**
 * 学习记录Model
 * @author Lingq
 *
 */
public class Record {

	private int recordId; //学习记录ID
	private int userId; //用户ID
	private String recites; //学习记录,存放ID，用逗号隔开
	
	/*
	 * get方法
	 */
	public int getRecordId() {
		return recordId;
	}
	public int getUserId() {
		return userId;
	}
	public String getRecites() {
		return recites;
	}
	
	/*
	 * set方法
	 */
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setRecites(String recites) {
		this.recites = recites;
	}
}
