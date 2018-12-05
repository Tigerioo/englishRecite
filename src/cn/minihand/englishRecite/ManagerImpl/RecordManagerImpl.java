package cn.minihand.englishRecite.ManagerImpl;

import java.util.List;

import org.apache.log4j.Logger;

import cn.minihand.englishRecite.Manager.RecordManager;
import cn.minihand.englishRecite.model.Record;
import cn.minihand.englishRecite.util.JDBCTemplate;

public class RecordManagerImpl implements RecordManager{
	private Logger logger = Logger.getLogger(UserManagerImpl.class);
	private JDBCTemplate jdbcTemplate;
	
	/*
	 * ×¢Èëµ½SpringÖÐ
	 */
	public void setJdbcTemplate(JDBCTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void add(Record record) {
		jdbcTemplate.add(record);
	}

	public void delete(Record record) {
		jdbcTemplate.delete(record);
	}

	public List<Record> findAll() {
		return this.jdbcTemplate.findAll(new Record());
	}

	public Record findById(int recordId) {
		
		return (Record)this.jdbcTemplate.findById(new Record(), recordId);
	}

	public void update(Record record) {
		this.jdbcTemplate.update(record);
	}

}
