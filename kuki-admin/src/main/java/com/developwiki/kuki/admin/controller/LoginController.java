package com.developwiki.kuki.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.developwiki.kuki.basic.entity.Menu;
import com.developwiki.kuki.basic.utils.Md5Utils;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/do_login")
	public String doLogin(HttpServletRequest request, Model model){
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		boolean rememberMe = false;
		String md5Pwd = Md5Utils.generatePassword(pwd);
		try {
			UsernamePasswordToken token = new UsernamePasswordToken(username, md5Pwd, rememberMe);
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			
			//��ת��һ���˵�
			List<Menu> hasResource = (List<Menu>) request.getSession().getAttribute(WebHelper.SESSION_MENU_RESOURCE);
			if(hasResource != null && !hasResource.isEmpty()){
				for(Menu menu : hasResource){
					
					List<Menu> chResources = menu.getChildren();
					if(StringUtils.isNotBlank(menu.getUrl()) && (chResources == null || chResources.isEmpty())){
						return "redirect:" + menu.getUrl();
					}
					if(chResources != null && !chResources.isEmpty()){
						for(Menu chRes : chResources){
							if(StringUtils.isNotBlank(chRes.getUrl())){
								return "redirect:" + chRes.getUrl();
							}
						}
					}
				}
			}
			
			return "redirect:/user/list";
		} catch (LockedAccountException lae) {
//			lae.printStackTrace();
			model.addAttribute("msg", "�˺��ѱ�����");
		} catch (AuthenticationException ae) {
//			ae.printStackTrace();
			model.addAttribute("msg", "�˺Ż��������");
		} catch (Exception e) {
//			e.printStackTrace();
			model.addAttribute("msg", "��¼�쳣");
		}
		return "login";
	}
	
	@RequestMapping("/login_out")
	public String loginOut(HttpServletRequest request){
		
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		
		return "redirect:/login";
	}
}
