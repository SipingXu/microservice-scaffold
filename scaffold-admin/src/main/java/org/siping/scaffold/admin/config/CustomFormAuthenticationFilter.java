package org.siping.scaffold.admin.config;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.siping.scaffold.admin.config.service.impl.UserService;
import org.siping.scaffold.platform.entity.SysUser;
import org.siping.scaffold.tools.shiro.KaptchaFormAuthenticationFilter;
import org.siping.scaffold.tools.util.IPUtil;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.context.support.MessageSourceAccessor;

import java.util.Date;


/**
 * @author Siping
 */
public class CustomFormAuthenticationFilter extends KaptchaFormAuthenticationFilter {

    private UserService userService;

    public CustomFormAuthenticationFilter(MessageSourceAccessor messageSourceAccessor, UserService userService) {
        super(messageSourceAccessor);
        this.userService = userService;
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
                                     ServletResponse response) throws Exception {
        Object principal = subject.getPrincipal();
        if (principal != null) {
            SysUser user = (SysUser) principal;
            user.setIp(IPUtil.getIp(request));
            user.setLastLoginTime(new Date());
            userService.updateUser(user);
        }
        return super.onLoginSuccess(token, subject, request, response);
    }


    @Override
    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
        WebUtils.issueRedirect(request, response, getSuccessUrl(), null, true);
    }

}
