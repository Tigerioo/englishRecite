package cn.minihand.englishRecite.Manager;

import java.util.List;

import cn.minihand.englishRecite.model.Content;

public interface ContentManager {
	
	public void add(Content content);
	
	public void delete(Content content);
	
	public void update(Content content);
	
	public Content findById(int contentId);
	
	public List<Content> findAll();
}	
