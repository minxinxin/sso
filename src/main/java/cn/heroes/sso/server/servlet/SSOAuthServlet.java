package cn.heroes.sso.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.heroes.sso.commons.Constant;

public class SSOAuthServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.setAttribute(Constants.REQUEST_HEADER_REFERER, request.getHeader("referer"));
		//String referer = request.getHeader("referer");
		String referer = request.getParameter("continue");
		PrintWriter out = response.getWriter();
		if(referer == null) {
			// goto account info page.
			out.println("goto account info page.");
		} else if(isURLAvailable(referer)) {
			
		} else {
			// goto url is unavailable page.
			out.println("url is unavailable.");
		}
		out.close();
	}
	
	private boolean hasSession(HttpSession session) {
		Object attr = session.getAttribute(Constant.SESSION_LOGIN_FIELD);
		return attr != null;
	}
	
	private boolean isURLAvailable(String url) {
		// TODO trust list. Can user turn it off.
		return true;
	}

	
}
