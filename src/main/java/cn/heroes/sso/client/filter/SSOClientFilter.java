package cn.heroes.sso.client.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class SSOClientFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		if(hasSession()) {
			chain.doFilter(req, resp);
		} else {
			HttpServletRequest request = (HttpServletRequest)req;
			HttpServletResponse response = (HttpServletResponse)resp;
			// 要先判断是不是从sso跳回来
			
			gotoSSOServer(request, response);
		}
	}
	
	/**
	 * 用户跳转到SSO Server
	 * @return
	 * @throws IOException 
	 */
	private void gotoSSOServer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("http://127.0.0.1:8080/sso/ssoauth");
	}
	
	public abstract boolean hasSession();
	
	public abstract boolean setSession();

	@Override
	public void init(FilterConfig config) throws ServletException {
		// get config, ip address
	}

}
