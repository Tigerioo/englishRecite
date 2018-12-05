package cn.minihand.englishRecite.model;

import java.util.Date;

/**
 * 背诵Model
 * @author Lingq
 *
 */
public class Recite {

	private int reciteId; //背诵ID
	private int userId; //用户ID
	private String createTime; //创建时间
	private String updateTime; //更新时间
	private String star; //星标
	private int contentId; //内容ID
	private int reciteTime; //背诵次数
	private int failTime; //失败次数
	private String isLearned; //是否通过
	
	/*
	 * get方法
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
	 * set方法
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
