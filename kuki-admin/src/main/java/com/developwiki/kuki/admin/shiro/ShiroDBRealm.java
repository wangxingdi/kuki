package com.developwiki.kuki.admin.shiro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.developwiki.kuki.basic.entity.Menu;
import com.developwiki.kuki.basic.entity.Role;
import com.developwiki.kuki.basic.entity.User;
import com.developwiki.kuki.basic.service.MenuService;
import com.developwiki.kuki.basic.service.UserService;

public class ShiroDBRealm extends AuthorizingRealm{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MenuService menuService;
	
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		String username = (String) principals.getPrimaryPrincipal();
		User user = userService.findByUsername(username);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Set<Role> roleSet = user.getRoles();

		Set<String> permissionSet = new HashSet<String>();
		for (Role role : roleSet) {
			if(StringUtils.isNotBlank(role.getRoleName())){
				info.addRole(role.getRoleName());
				Set<Menu> menuSet = role.getResources();
				if(menuSet!=null && !menuSet.isEmpty()){
					for(Menu r : menuSet){
						if(StringUtils.isNotBlank(r.getUrl())){
							permissionSet.add(r.getUrl());
						}
					}
				}
			}
		}
		
		info.addStringPermissions(permissionSet);

		return info;
	}

	/**
	 * 验证当前用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
        
        if(StringUtils.isEmpty(token.getUsername())){
        	return null;
        }
        
        User user = userService.findUserByName(token.getUsername());
        if(user != null){
        	
        	if(user.getStatus() == User.STATUS_NO){
        		throw new LockedAccountException();
        	}
        	
        	AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
        	
        	setSession(WebHelper.SESSION_LOGIN_USER, user);
        	
        	initMenu(user.getId());
        	
        	return authcInfo;
        }
        
        return null;
	}
	
	private void initMenu(String userId){

		//菜单权限
		List<Menu> menuResources = resourceService.findAllMenu();
		
		List<Menu> hasResource = new ArrayList<Menu>();
		
		Map<String, Object> map = userService.findResourceMap(userId);
		
		if(menuResources != null && !menuResources.isEmpty()){
			for(Menu menu : menuResources){
				Menu retRes = hasResource(menu, map);
				if(retRes != null){
					hasResource.add(retRes);
				}
			}
		}
		
		setSession(WebHelper.SESSION_MENU_RESOURCE, hasResource);
		
	}
	
	private Menu hasResource(Menu resource, Map<String, Object> map){
		if(map.containsKey(resource.getId())){
			List<Menu> chResources = resource.getChildren();
			List<Menu> hasChResources = new ArrayList<Menu>();
			if(chResources != null && !chResources.isEmpty()){
				for(Menu chRes : chResources){
					Menu retRes = hasResource(chRes, map);
					if(retRes != null){
						hasChResources.add(retRes);
					}
				}
			}
			resource.setChildren(hasChResources);
			return resource;
		}else{
			return null;
		}
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 */
	private void setSession(Object key, Object value){
		Subject subject = SecurityUtils.getSubject();
		if(subject != null){
			Session session = subject.getSession();
			if(session != null){
				session.setAttribute(key, value);
			}
		}
	}

}
