package cn.minihand.englishRecite.Manager;

import java.util.List;

import cn.minihand.englishRecite.model.User;

public interface UserManager {
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(int userId);
	
	public User findUserById(int userId);
	
	public User findUserByName(String username);
	
	public List<User> findUsers();
}
