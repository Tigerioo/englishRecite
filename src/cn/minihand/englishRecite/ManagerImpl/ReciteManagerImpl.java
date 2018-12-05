package cn.minihand.englishRecite.ManagerImpl;

import java.util.List;

import org.apache.log4j.Logger;

import cn.minihand.englishRecite.Manager.ReciteManager;
import cn.minihand.englishRecite.model.Content;
import cn.minihand.englishRecite.model.Recite;
import cn.minihand.englishRecite.util.JDBCTemplate;

public class ReciteManagerImpl implements ReciteManager{
	private Logger logger = Logger.getLogger(UserManagerImpl.class);
	private JDBCTemplate jdbcTemplate;
	
	/*
	 * ×¢Èëµ½SpringÖÐ
	 */
	public void setJdbcTemplate(JDBCTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void add(Recite recite) {
		jdbcTemplate.add(recite);
	}

	public void delete(Recite recite) {
		jdbcTemplate.delete(recite);
	}

	public List<Recite> findAll() {
		return this.jdbcTemplate.findAll(new Recite());
	}

	public Recite findById(int reciteId) {
		
		return (Recite)this.jdbcTemplate.findById(new Recite(), reciteId);
	}

	public void update(Recite recite) {
		this.jdbcTemplate.update(recite);
	}

}
