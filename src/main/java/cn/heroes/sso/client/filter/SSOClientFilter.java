package cn.heroes.sso.client.filter;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.heroes.sso.commons.Constant;

public abstract class SSOClientFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		HttpSession session = request.getSession();
		
		String flag = request.getParameter(Constant.PARAM_LOGIN_FIELD);
		if(flag != null) {
			// TODO 1 logout
			removeSession(session);
		} else if(hasSession(session)) {
			// TODO 2 tell server I am alive.
			chain.doFilter(req, resp);
		} else {
			// 要先判断是不是从sso跳回来 TODO 3 ticket
			gotoSSOServer(request, response);
		}
	}
	
	/**
	 * 用户带着原先请求的链接跳转到SSO Server
	 * @return
	 * @throws IOException 
	 */
	private void gotoSSOServer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StringBuffer requestURL = request.getRequestURL();
		String queryString = request.getQueryString();
		if(queryString != null) {
			requestURL.append("?").append(queryString);
		}
		response.sendRedirect("http://127.0.0.1:8080/sso/ssoauth?continue=" + URLEncoder.encode(requestURL.toString(), "UTF-8"));
	}
	
	/**
	 * 与本站(App)是否存在会话
	 * @return
	 */
	public abstract boolean hasSession(HttpSession session);
	
	/**
	 * 加入本站(App)会话
	 * @return
	 */
	public abstract void addSession(HttpSession session);
	
	/**
	 * 注销本站(App)会话
	 * @param session
	 */
	public abstract void removeSession(HttpSession session);

	@Override
	public void init(FilterConfig config) throws ServletException {
		// get config, ip address
	}

}
