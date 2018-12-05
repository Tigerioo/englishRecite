package cn.minihand.englishRecite.Manager;

import java.util.List;

import cn.minihand.englishRecite.model.Recite;

public interface ReciteManager {
	public void add(Recite recite);

	public void delete(Recite recite);

	public void update(Recite recite);

	public Recite findById(int reciteId);

	public List<Recite> findAll();
}
