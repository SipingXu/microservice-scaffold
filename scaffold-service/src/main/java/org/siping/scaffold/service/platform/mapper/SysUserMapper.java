package org.siping.scaffold.service.platform.mapper;

import org.siping.scaffold.platform.entity.SysUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.siping.scaffold.vo.ChartVO;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author Siping
 * @since 2018-01-13
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

	List<ChartVO> loginCount();
}
