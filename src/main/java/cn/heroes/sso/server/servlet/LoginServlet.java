package cn.heroes.sso.server.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		
		// The URL goto after this page
		String conti = req.getParameter("continue");
		// The URL from before this page
		String referer = req.getHeader("referer");
		
		//req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, res);
		System.out.println(action);
		System.out.println(conti);
		System.out.println(referer);
	}
}
