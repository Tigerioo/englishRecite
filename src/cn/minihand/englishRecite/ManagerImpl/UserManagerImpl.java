package cn.minihand.englishRecite.ManagerImpl;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import cn.minihand.englishRecite.Manager.UserManager;
import cn.minihand.englishRecite.model.User;
import cn.minihand.englishRecite.util.JDBCTemplate;

public class UserManagerImpl implements UserManager {

	private Logger logger = Logger.getLogger(UserManagerImpl.class);
	private JDBCTemplate jdbcTemplate;
	
	/*
	 * ע�뵽Spring��
	 */
	public void setJdbcTemplate(JDBCTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/*
	 * �����û�
	 * @see cn.minihand.englishRecite.Dao.UserDao#addUser(cn.minihand.englishRecite.model.User)
	 */
	public void addUser(User user) {
		this.jdbcTemplate.add(user);
	}

	/*
	 * (non-Javadoc)
	 * @see cn.minihand.englishRecite.Manager.UserManager#deleteUser(int)
	 */
	public void deleteUser(int userId) {
		User user = (User)this.jdbcTemplate.findById(new User(), userId);
		this.jdbcTemplate.delete(user);
	}

	public User findUserById(int userId) {
		return (User)this.jdbcTemplate.findById(new User(), userId);
	}

	public User findUserByName(String username) {
		return (User)this.jdbcTemplate.findByName(new User(), username);
	}
	
	public ArrayList<User> findUsers() {
		return this.jdbcTemplate.findAll(new User());
	}

	/*
	 * �����û�
	 * @see cn.minihand.englishRecite.Dao.UserDao#updateUser(cn.minihand.englishRecite.model.User)
	 */
	public void updateUser(User user) {
		this.jdbcTemplate.update(user);
	}
}
