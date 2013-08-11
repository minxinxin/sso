package cn.heroes.sso.client.filter;

import javax.servlet.http.HttpSession;

import cn.heroes.sso.commons.Constant;

/**
 * <code>SSOClientFilter</code>的简单实现, 开发者可自行实现.
 *
 * @author Leon Kidd
 * @version 1.00, 2013-8-10
 * @since 1.0
 */
public class SimpleSSOClientFilter extends SSOClientFilter {

	@Override
	public boolean hasSession(HttpSession session) {
		Object attr = session.getAttribute(Constant.SESSION_LOGIN_FIELD);
		return attr != null;
	}

	@Override
	public void addSession(HttpSession session) {
		session.setAttribute(Constant.SESSION_LOGIN_FIELD, new Object());
	}

	@Override
	public void removeSession(HttpSession session) {
		session.removeAttribute(Constant.SESSION_LOGIN_FIELD);
	}

}
