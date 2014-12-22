package com.px1.horizonairways.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.px1.horizonairways.da.LoginDA;
import com.px1.horizonairways.daimpl.LoginDAImpl;
import com.px1.horizonairways.entity.Login;
import com.px1.horizonairways.entity.User;
import com.px1.horizonairways.service.LoginService;

public class AuthenticationAction extends ActionSupport implements
		ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private Login login;

	public String login() {

		LoginService loginService = new LoginService();
		LoginDA da = new LoginDAImpl();
		loginService.setLoginDA(da);
		User user = loginService.validateUser(login);

		if (user != null && user.getRole().contains("admin")) {

			request.getSession().setAttribute("admin", "admin");
		}
		
		request.getSession().setAttribute("user", user);

		return SUCCESS;

	}

	public String logout() {

		request.getSession().invalidate();

		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}
