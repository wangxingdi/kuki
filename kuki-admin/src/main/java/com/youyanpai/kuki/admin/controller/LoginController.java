package com.youyanpai.kuki.admin.controller;

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

import com.youyanpai.kuki.admin.constant.SessionConstant;
import com.youyanpai.kuki.basic.entity.Menu;
import com.youyanpai.kuki.basic.util.Md5Utils;

/**
 * 登录控制类
 * @author wangxd
 */
@Controller
public class LoginController {

	/**
	 * 去登录
	 * @return String
	 * @author wangxd
	 */
	@RequestMapping("/toLogin")
	public String login(){
		return "login";
	}
	
	/**
	 * 登录
	 * @param request
	 * @param model
	 * @return String
	 * @author wangxd
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model){
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		boolean rememberMe = false;
		String md5Pwd = Md5Utils.encodePassword(pwd);
		try {
			UsernamePasswordToken token = new UsernamePasswordToken(username, md5Pwd, rememberMe);
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			
			//跳转第一个菜单
			List<Menu> menuList = (List<Menu>) request.getSession().getAttribute(SessionConstant.SESSION_MENU);
			/*if(menuList != null && !menuList.isEmpty()){
				for(Menu menu : menuList){
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
			}*/
			return "redirect:/user/list";
		} catch (LockedAccountException lae) {
//			lae.printStackTrace();
			model.addAttribute("msg", "账号已被禁用");
		} catch (AuthenticationException ae) {
//			ae.printStackTrace();
			model.addAttribute("msg", "账号或密码错误");
		} catch (Exception e) {
//			e.printStackTrace();
			model.addAttribute("msg", "登录异常");
		}
		return "login";
	}
	
	/**
	 * 登出
	 * @param request
	 * @return String
	 * @author wangxd
	 */
	@RequestMapping("/login_out")
	public String loginOut(HttpServletRequest request){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/login";
	}
}
