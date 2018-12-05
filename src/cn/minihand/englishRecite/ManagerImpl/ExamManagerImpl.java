package cn.minihand.englishRecite.ManagerImpl;

import java.util.List;

import org.apache.log4j.Logger;

import cn.minihand.englishRecite.Manager.ExamManager;
import cn.minihand.englishRecite.model.Exam;
import cn.minihand.englishRecite.util.JDBCTemplate;

public class ExamManagerImpl implements ExamManager{
	private Logger logger = Logger.getLogger(UserManagerImpl.class);
	private JDBCTemplate jdbcTemplate;
	
	/*
	 * ×¢Èëµ½SpringÖÐ
	 */
	public void setJdbcTemplate(JDBCTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void add(Exam exam) {
		jdbcTemplate.add(exam);
	}

	public void delete(Exam exam) {
		jdbcTemplate.delete(exam);
	}

	public List<Exam> findAll() {
		return this.jdbcTemplate.findAll(new Exam());
	}

	public Exam findById(int examId) {
		
		return (Exam)this.jdbcTemplate.findById(new Exam(), examId);
	}

	public void update(Exam exam) {
		this.jdbcTemplate.update(exam);
	}

}
