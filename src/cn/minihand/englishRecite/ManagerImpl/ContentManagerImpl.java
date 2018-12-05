package cn.minihand.englishRecite.ManagerImpl;

import java.util.List;

import org.apache.log4j.Logger;

import cn.minihand.englishRecite.Manager.ContentManager;
import cn.minihand.englishRecite.model.Content;
import cn.minihand.englishRecite.util.JDBCTemplate;

public class ContentManagerImpl implements ContentManager{
	private Logger logger = Logger.getLogger(UserManagerImpl.class);
	private JDBCTemplate jdbcTemplate;
	
	/*
	 * ×¢Èëµ½SpringÖÐ
	 */
	public void setJdbcTemplate(JDBCTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void add(Content content) {
		jdbcTemplate.add(content);
	}

	public void delete(Content content) {
		jdbcTemplate.delete(content);
	}

	public List<Content> findAll() {
		return this.jdbcTemplate.findAll(new Content());
	}

	public Content findById(int contentId) {
		
		return (Content)this.jdbcTemplate.findById(new Content(), contentId);
	}

	public void update(Content content) {
		this.jdbcTemplate.update(content);
	}

}
