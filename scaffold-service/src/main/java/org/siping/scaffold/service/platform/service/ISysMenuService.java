package org.siping.scaffold.service.platform.service;

import org.siping.scaffold.platform.entity.SysMenu;
import com.baomidou.mybatisplus.service.IService;
import org.siping.scaffold.vo.TreeNode;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Siping
 * @since 2018-01-14
 */
public interface ISysMenuService extends IService<SysMenu> {

	List<TreeNode> selectByRoleId(String roleId);

	List<SysMenu> selectByUser(String userId);

	List<String> selectPermit(String userId);


}
