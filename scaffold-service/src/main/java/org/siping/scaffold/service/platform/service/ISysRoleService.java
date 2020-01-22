package org.siping.scaffold.service.platform.service;

import com.baomidou.mybatisplus.plugins.Page;
import org.siping.scaffold.platform.entity.SysRole;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Siping
 * @since 2018-01-14
 */
public interface ISysRoleService extends IService<SysRole> {

    /**
     * 角色分页查询
     * @param page
     * @return
     */
    Page<SysRole> queryPage(Page<SysRole> page);

	/**
	 * 绑定资源
	 * @param id
	 * @param resourceIds
	 * @return
	 */
    boolean bindResource(String id,String[] resourceIds);
}
