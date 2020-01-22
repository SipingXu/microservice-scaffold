package org.siping.scaffold.api.config.support;

import org.siping.scaffold.api.platform.api.ISysUserService;
import org.siping.scaffold.platform.entity.SysUser;
import org.siping.scaffold.tools.result.ResultModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Siping
 */
@Service("userService")
public class UserService implements IUserService {

    @Resource
    private ISysUserService sysUserService;

    public ResultModel<String> updateUser(SysUser user){
        return sysUserService.saveOrUpdate(user);
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return sysUserService.getByUsername(username);
	}
}
