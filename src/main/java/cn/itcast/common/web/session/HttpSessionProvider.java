package cn.itcast.common.web.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 本地Session
 * @author lx
 *
 */
public class HttpSessionProvider implements SessionProvider{

	
	public void setAttribute(HttpServletRequest request, String name,
			Serializable value) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();//true    Cookie JSESSIONID
		session.setAttribute(name, value);
	}

	
	public Serializable getAttribute(HttpServletRequest request, String name) {
		HttpSession session = request.getSession(false);
		if(session != null){
			return (Serializable) session.getAttribute(name);
		}
		return null;
	}

	
	public void logout(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if(session != null){
			session.invalidate();
		}
		//Cookie JSESSIONID 
		
	}

	
	public String getSessionId(HttpServletRequest request) {
		// TODO Auto-generated method stub
		//request.getRequestedSessionId();  //Http://localhost:8080/html/sfsf.shtml?JESSIONID=ewrqwrq234123412
		return request.getSession().getId();
	}

}
