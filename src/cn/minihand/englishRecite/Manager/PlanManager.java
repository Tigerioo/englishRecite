package cn.minihand.englishRecite.Manager;

import java.util.List;

import cn.minihand.englishRecite.model.Plan;

public interface PlanManager {
	
	public void add(Plan plan);
	
	public void delete(Plan plan);
	
	public void update(Plan plan);
	
	public Plan findById(int planId);
	
	public List<Plan> findAll();
}	
