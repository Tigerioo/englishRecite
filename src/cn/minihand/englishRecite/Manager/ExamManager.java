package cn.minihand.englishRecite.Manager;

import java.util.List;

import cn.minihand.englishRecite.model.Exam;

public interface ExamManager {
	
	public void add(Exam exam);
	
	public void delete(Exam exam);
	
	public void update(Exam exam);
	
	public Exam findById(int examId);
	
	public List<Exam> findAll();
}	
