package cn.minihand.englishRecite.model;

/**
 * ѧϰ��¼Model
 * @author Lingq
 *
 */
public class Record {

	private int recordId; //ѧϰ��¼ID
	private int userId; //�û�ID
	private String recites; //ѧϰ��¼,���ID���ö��Ÿ���
	
	/*
	 * get����
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
	 * set����
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
