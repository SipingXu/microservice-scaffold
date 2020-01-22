package org.siping.scaffold.api.config;

import org.siping.scaffold.platform.entity.SysUser;
import org.siping.scaffold.tools.util.FastJsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Siping
 * @date 2018/5/7 11:48
 * @description
 */
public class UserUtil {

	private static final String ANONYMOUS_USER = "anonymousUser";

	public static SysUser getCurrentUser(){
		Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (obj == null || StringUtils.isBlank(obj.toString()) || ANONYMOUS_USER.equals(obj)) {
			return null;
		}
		return FastJsonUtils.toBean(obj.toString(), SysUser.class);
	}
}
