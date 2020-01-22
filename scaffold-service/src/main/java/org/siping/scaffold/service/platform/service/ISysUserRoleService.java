package org.siping.scaffold.service.platform.service;

import org.siping.scaffold.platform.entity.SysUserRole;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Siping
 * @since 2018-01-14
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

    List<String> getRoleIds(String userId);
}
