package org.siping.scaffold.service.platform.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.siping.scaffold.platform.entity.SysUser;
import org.siping.scaffold.platform.entity.SysUserRole;
import org.siping.scaffold.service.platform.mapper.SysUserMapper;
import org.siping.scaffold.service.platform.service.ISysUserRoleService;
import org.siping.scaffold.service.platform.service.ISysUserService;
import org.siping.scaffold.tools.exception.NormalException;
import org.siping.scaffold.tools.util.IDGen;
import org.siping.scaffold.tools.util.StringUtil;
import org.siping.scaffold.vo.ChartVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Siping
 * @since 2018-01-13
 */
@Service
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Resource
    private ISysUserRoleService userRoleService;

    @Resource
	private SysUserMapper sysUserMapper;

    @Override
    public Page<SysUser> queryPage(Page<SysUser> page) {
        return this.selectPage(page, new EntityWrapper<>());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdate(SysUser sysUser) {
        checkUsername(sysUser);
        boolean r;
        if (StringUtil.isBlank(sysUser.getId())) {
            sysUser.setId(IDGen.genId());
            r = this.insert(sysUser);
        } else {
            deleteUserRole(sysUser.getId());
            r = this.updateById(sysUser);
        }
        saveUserRole(sysUser.getId(),sysUser.getRoleIds());
        return r;
    }

	@Override
	public List<ChartVO> loginCount() {
		return sysUserMapper.loginCount();
	}

	@Override
	public List<SysUser> getAll(SysUser user) {
    	EntityWrapper<SysUser> entityWrapper = new EntityWrapper<>();
    	entityWrapper.orderBy("create_time");
		entityWrapper.setEntity(user);
		return this.selectList(entityWrapper);
	}

	private void deleteUserRole(String userId) {
        EntityWrapper<SysUserRole> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("user_id",userId);
        userRoleService.delete(entityWrapper);
    }

    private void saveUserRole(String userId, List<String> roleIds) {
    	if (roleIds == null){
    		return;
		}
        roleIds.stream().filter(StringUtil::isNotBlank).forEach(roleId->{
            SysUserRole userRole = new SysUserRole();
            userRole.setRoleId(roleId);
            userRole.setUserId(userId);
            userRoleService.insert(userRole);
        });
    }

    private void checkUsername(SysUser sysUser) {
        EntityWrapper<SysUser> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("username",sysUser.getUsername());
        SysUser dbUser = this.selectOne(entityWrapper);
        if (dbUser != null && !sysUser.getId().equals(dbUser.getId())){
            throw new NormalException("该用户名已被占用");
        }
    }
}
