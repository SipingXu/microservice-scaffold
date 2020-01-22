package org.siping.scaffold.service.platform.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.siping.scaffold.platform.entity.SysUserRole;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.siping.scaffold.service.platform.mapper.SysUserRoleMapper;
import org.siping.scaffold.service.platform.service.ISysUserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Siping
 * @since 2018-01-14
 */
@Service
public class SysUserRoleService extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

    @Override
    public List<String> getRoleIds(String userId) {
        EntityWrapper<SysUserRole> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("user_id",userId);
        List<SysUserRole> userRoles = this.selectList(entityWrapper);
        List<String> roleIds = userRoles.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        return roleIds;
    }
}
