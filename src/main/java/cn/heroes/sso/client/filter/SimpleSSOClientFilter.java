package cn.heroes.sso.client.filter;

import javax.servlet.http.HttpSession;

public class SimpleSSOClientFilter extends SSOClientFilter {

	private static final String SESSION_FIELD = "cn.heroes.sso.client.Session";

	@Override
	public boolean hasSession(HttpSession session) {
		Object attr = session.getAttribute(SESSION_FIELD);
		return attr != null;
	}

	@Override
	public void addSession(HttpSession session) {
		session.setAttribute(SESSION_FIELD, new Object());
	}

	@Override
	public void removeSession(HttpSession session) {
		session.removeAttribute(SESSION_FIELD);
	}

}
