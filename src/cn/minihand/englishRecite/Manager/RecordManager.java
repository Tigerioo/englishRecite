package cn.minihand.englishRecite.Manager;

import java.util.List;

import cn.minihand.englishRecite.model.Record;

public interface RecordManager {
	
	public void add(Record record);
	
	public void delete(Record record);
	
	public void update(Record record);
	
	public Record findById(int recordId);
	
	public List<Record> findAll();
}	
