package com.developwiki.kuki.admin.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * 
 * @author wangxd
 */
public class RememberAuthenticationFilter extends FormAuthenticationFilter{
	
	/**
	 * ≈–∂œ «∑Ò»√”√ªßµ«¬Ω
	 * @param request
	 * @param response
	 * @param mappedValue
	 * @return boolean
	 * @author wangxd
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		
		Subject subject = getSubject(request, response);
		
		return subject.isAuthenticated() || subject.isRemembered();
	}

}
