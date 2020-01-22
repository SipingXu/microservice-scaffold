package org.siping.scaffold.admin.config.service.impl;

import org.siping.scaffold.admin.platform.api.ISysUserService;
import org.siping.scaffold.platform.entity.SysUser;
import org.siping.scaffold.tools.result.ResultModel;
import org.siping.scaffold.tools.shiro.entity.IUser;
import org.siping.scaffold.tools.shiro.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserService implements IUserService {

    @Resource
    private ISysUserService sysUserService;

    @Override
    public IUser findUserByUsername(String username) {
        return sysUserService.getByUsername(username);
    }

    public ResultModel<String> updateUser(SysUser user){
        return sysUserService.saveOrUpdate(user);
    }
}
