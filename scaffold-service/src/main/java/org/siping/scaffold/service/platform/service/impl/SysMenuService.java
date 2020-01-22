package org.siping.scaffold.service.platform.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.siping.scaffold.enumeration.MenuType;
import org.siping.scaffold.platform.entity.SysMenu;
import org.siping.scaffold.service.platform.mapper.SysMenuMapper;
import org.siping.scaffold.service.platform.service.ISysMenuService;
import org.siping.scaffold.tools.util.StringUtil;
import org.siping.scaffold.vo.TreeNode;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Siping
 * @since 2018-01-14
 */
@Service
public class SysMenuService extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<TreeNode> selectByRoleId(String roleId) {
        return sysMenuMapper.selectResource(roleId);
    }

    @Override
    @Cacheable(cacheNames="userMenus",key = "#p0")
    public List<SysMenu> selectByUser(String userId) {
        System.out.println("进来开始获取~~");
        if (StringUtil.isNotBlank(userId)) {
            return sysMenuMapper.selectByUser(userId, MenuType.MENU.getCode());
        }
        return sysMenuMapper.selectAllMenu(SysMenu.MENU_TYPE_RESOURCE);
    }

    @Override
    public List<String> selectPermit(String userId) {
        if (StringUtil.isNotBlank(userId)) {
            return sysMenuMapper.selectPermit(userId);
        }
        return sysMenuMapper.selectAllPermit(SysMenu.MENU_TYPE_PERMIT);
    }
}
