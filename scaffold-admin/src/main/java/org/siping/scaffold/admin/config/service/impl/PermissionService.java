package org.siping.scaffold.admin.config.service.impl;

import org.siping.scaffold.admin.config.service.IPermissionService;
import org.siping.scaffold.admin.platform.api.ISysPermissionService;
import org.siping.scaffold.tools.result.ResultModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("permissionService")
public class PermissionService implements IPermissionService {

    @Resource
    private ISysPermissionService sysPermissionService;

    @Override
    public ResultModel<List<String>> getPermissions(String userId) {
        return sysPermissionService.getPermissions(userId);
    }
}
