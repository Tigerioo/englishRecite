package cn.minihand.englishRecite.servlets;

import java.io.File;
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

public class ContentServlet extends HttpServlet {

	private Logger logger = Logger.getLogger(ContentServlet.class);
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

	}

	protected void delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 从spring中读取userManager
		ServletContext context = getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils
				.getWebApplicationContext(context);

	}

	protected void findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 从spring中读取userManager
		ServletContext context = getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils
				.getWebApplicationContext(context);

	}

}
