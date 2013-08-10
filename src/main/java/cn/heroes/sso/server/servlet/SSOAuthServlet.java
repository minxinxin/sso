package cn.heroes.sso.server.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SSOAuthServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.setAttribute(Constants.REQUEST_HEADER_REFERER, request.getHeader("referer"));
		//String referer = request.getHeader("referer");
		System.out.println(request);
	}

	
}
