package org.siping.scaffold.service.platform.service;

import com.baomidou.mybatisplus.plugins.Page;
import org.siping.scaffold.platform.entity.SysUser;
import com.baomidou.mybatisplus.service.IService;
import org.siping.scaffold.vo.ChartVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Siping
 * @since 2018-01-13
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 分页查询
     * @param page
     * @return
     */
    Page<SysUser> queryPage(Page<SysUser> page);

	/**
	 * 新增/保存
	 * @param sysUser
	 * @return
	 */
    boolean saveOrUpdate(SysUser sysUser);

	/**
	 * 登录统计分析
	 * @return
	 */
    List<ChartVO> loginCount();

	/**
	 * 获取全部用户
	 * @param user
	 * @return
	 */
    List<SysUser> getAll(SysUser user);
}
