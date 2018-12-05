package cn.minihand.englishRecite.ManagerImpl;

import java.util.List;

import org.apache.log4j.Logger;

import cn.minihand.englishRecite.Manager.PlanManager;
import cn.minihand.englishRecite.model.Plan;
import cn.minihand.englishRecite.util.JDBCTemplate;

public class PlanManagerImpl implements PlanManager{
	private Logger logger = Logger.getLogger(UserManagerImpl.class);
	private JDBCTemplate jdbcTemplate;
	
	/*
	 * ×¢Èëµ½SpringÖÐ
	 */
	public void setJdbcTemplate(JDBCTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void add(Plan plan) {
		jdbcTemplate.add(plan);
	}

	public void delete(Plan plan) {
		jdbcTemplate.delete(plan);
	}

	public List<Plan> findAll() {
		return this.jdbcTemplate.findAll(new Plan());
	}

	public Plan findById(int planId) {
		
		return (Plan)this.jdbcTemplate.findById(new Plan(), planId);
	}

	public void update(Plan plan) {
		this.jdbcTemplate.update(plan);
	}

}
