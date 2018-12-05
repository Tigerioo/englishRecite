package cn.minihand.englishRecite.util;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.minihand.englishRecite.Manager.UserManager;
import cn.minihand.englishRecite.model.User;

public class DbTest {
	public static void main(String[] args) throws SQLException, IOException {
		ApplicationContext context1 = new ClassPathXmlApplicationContext("applicationContext-datasource.xml");
		ApplicationContext context2 = new ClassPathXmlApplicationContext("applicationContext-manager.xml");
		ApplicationContext context3 = new ClassPathXmlApplicationContext("applicationContext-util.xml");
		//UserManager userManager = (UserManager)context.getBean("userManager");
		
		JDBCTemplate ds = (JDBCTemplate)context3.getBean("jdbcTemplate");
		
		User user = new User();
		user.setExams("sddsf");
		user.setUsername("sfdvvvsdfsdf");
		ds.add(user);
	}
}
