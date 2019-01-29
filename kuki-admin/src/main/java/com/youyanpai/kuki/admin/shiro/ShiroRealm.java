package com.youyanpai.kuki.admin.shiro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
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

import com.youyanpai.kuki.admin.constant.SessionConstant;
import com.youyanpai.kuki.basic.constant.DictConstant;
import com.youyanpai.kuki.basic.entity.Menu;
import com.youyanpai.kuki.basic.entity.Role;
import com.youyanpai.kuki.basic.entity.User;
import com.youyanpai.kuki.basic.service.MenuService;
import com.youyanpai.kuki.basic.service.RoleService;
import com.youyanpai.kuki.basic.service.UserService;

/**
 * 
 * @author wangxd
 */
public class ShiroRealm extends AuthorizingRealm{
	
	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private RoleService roleService;
	
	/**
	 * 授权
	 * @param principals
	 * @return AuthorizationInfo
	 * @author wangxd
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		String username = (String) principals.getPrimaryPrincipal();
		User user = userService.findByUsername(username);
		List<Role> roleList = roleService.findByUserId(user.getUserId());
		List<String> roleIdList = new ArrayList<String>();
		for(Role role : roleList){
			roleIdList.add(role.getRoleId());
		}
		List<Menu> menuList = menuService.findByRoleIdList(roleIdList);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Set<String> permissionSet = new HashSet<String>();
		for (Role role : roleList) {
			if(StringUtils.isNotBlank(role.getRoleName())){
				info.addRole(role.getRoleName());
				if(menuList!=null && !menuList.isEmpty()){
					for(Menu menu : menuList){
						if(StringUtils.isNotBlank(menu.getMenuCode())){
							permissionSet.add(menu.getMenuCode());
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
	 * @param authcToken
	 * @return AuthenticationInfo
	 * @author wangxd 
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
        if(StringUtils.isEmpty(token.getUsername())){
        	return null;
        }
        User user = userService.findByUsername(token.getUsername());
        if(user != null){
        	if(user.getStatus() == DictConstant.USER_STATUS_NO){
        		throw new LockedAccountException();
        	}
        	AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPwd(), getName());
        	setSession(SessionConstant.SESSION_USER, user);
        	initMenu(user.getUserId());
        	return authcInfo;
        }
        return null;
	}
	
	/**
	 * 初始化菜单
	 * @param userId
	 * @author wangxd
	 */
	private void initMenu(String userId){
		//菜单权限
		List<Menu> menuResources = menuService.findAllMenu();
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
		setSession(SessionConstant.SESSION_MENU, hasResource);
	}
	
	/**
	 * @param resource
	 * @param map
	 * @return Menu
	 * @author wangxd
	 */
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
	 * 保存会话
	 * @param key
	 * @param value
	 * @author wangxd
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
