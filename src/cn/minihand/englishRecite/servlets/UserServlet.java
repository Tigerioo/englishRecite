package cn.minihand.englishRecite.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.minihand.englishRecite.ManagerImpl.UserManagerImpl;
import cn.minihand.englishRecite.model.User;

public class UserServlet extends HttpServlet {

	private Logger logger = Logger.getLogger(UserServlet.class);
	private UserManagerImpl userManager;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String method = request.getParameter("method");
		if ("add".equalsIgnoreCase(method)) {
			this.add(request, response);
		} else if ("delete".equals(method)) {
			this.delete(request, response);
		} else if ("login".equals(method)) {
			login(request,response);
		} else {
			this.findAll(request, response);
		}

	}

	protected void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从spring中读取userManager
		ServletContext context = getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils
				.getWebApplicationContext(context);
		userManager = (UserManagerImpl) wac.getBean("userManager");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		logger.info("username=" + username + ";\n passowrd =" + password2);
		
		if(!password.equals(password2)){
			request.getRequestDispatcher("/fail.jsp").forward(request, response);
		}else {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);

			userManager.addUser(user);

			request.getRequestDispatcher("/userCenter.jsp").forward(request, response);
		}
	}

	protected void delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 从spring中读取userManager
		ServletContext context = getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils
				.getWebApplicationContext(context);
		userManager = (UserManagerImpl) wac.getBean("userManager");

		String userId = request.getParameter("userId");
		userManager.deleteUser(Integer.parseInt(userId));

		request.getRequestDispatcher("/chat.jsp").forward(request, response);
	}

	protected void findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 从spring中读取userManager
		ServletContext context = getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils
				.getWebApplicationContext(context);
		userManager = (UserManagerImpl) wac.getBean("userManager");

		ArrayList<User> users = userManager.findUsers();

		request.setAttribute("users", users);
		request.getRequestDispatcher("/chat.jsp").forward(request, response);
	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从spring中读取userManager
		ServletContext context = getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils
				.getWebApplicationContext(context);
		userManager = (UserManagerImpl) wac.getBean("userManager");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown"))
			ip = request.getHeader("Proxy-Client-IP");
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown"))
			ip = request.getHeader("WL-Proxy-Client-IP");
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown"))
			ip = request.getRemoteAddr();
		logger.info("user ipaddress is " + ip);
		User user = null;
		String psw = null;
		if (!"".equals(username)) {
			user = userManager.findUserByName(username);
		}
		if (user != null) {
			psw = user.getPassword();
		}
		if (password.equalsIgnoreCase(psw)) {
			user.setOnlineIpAddress(ip);
			userManager.updateUser(user);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/userCenter.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("/fail.jsp")
					.forward(request, response);
		}
	}
}
