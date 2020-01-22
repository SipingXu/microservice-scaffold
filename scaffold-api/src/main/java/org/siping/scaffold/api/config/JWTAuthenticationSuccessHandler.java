package org.siping.scaffold.api.config;

import org.siping.scaffold.api.platform.api.ISysUserService;
import org.siping.scaffold.platform.entity.SysUser;
import org.siping.scaffold.tools.result.ResultModel;
import org.siping.scaffold.tools.result.ResultStatus;
import org.siping.scaffold.tools.util.FastJsonUtils;
import org.siping.scaffold.tools.util.IPUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author Siping
 */
@Component
public class JWTAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Resource
	private ISysUserService sysUserService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		Object principal = authentication.getPrincipal();
		if (principal != null) {
			SysUser user = (SysUser) principal;
			response.setContentType("application/json");
			SysUser updateAccUser = new SysUser();
			updateAccUser.setId(user.getId());
			updateAccUser.setLastLoginTime(new Date());
			updateAccUser.setIp(IPUtil.getIp(request));
			sysUserService.saveOrUpdate(updateAccUser);
			response.getWriter().write(FastJsonUtils.toJSONString(new ResultModel<>(ResultStatus.SUCCESS, user)));
		}
	}

}
