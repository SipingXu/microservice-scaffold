package org.siping.scaffold.api.platform.controller;

import org.siping.scaffold.api.config.UserUtil;
import org.siping.scaffold.api.platform.api.ISysUserService;
import org.siping.scaffold.platform.entity.SysUser;
import org.siping.scaffold.tools.controller.BaseController;
import org.siping.scaffold.tools.shiro.entity.IUser;
import org.siping.scaffold.tools.shiro.utils.PrincipalUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Siping
 * @date 2018/5/7 11:07
 * @description
 */
@RestController
public class DemoController extends BaseController{

	@Resource
	private ISysUserService sysUserService;

	@RequestMapping("demo/test1")
	public String test1(){
		IUser user = PrincipalUtils.getCurrentUser();
		String string = "this is test111111111";
		System.out.println(string);
		return string;
	}

	@RequestMapping("mine/demo/test2")
	public String test2(){
		SysUser user = UserUtil.getCurrentUser();
		String string = "this is test2222222";
		System.out.println(string);
		return string;
	}

	/*@PostMapping("/login")
	public ResultModel<String> login(@RequestParam("username") String username,
							 @RequestParam("password") String password) {
		SysUser user = sysUserService.getByUsername(username);
		if (user == null){
			throw new NormalException("用户名不正确");
		}
		String md5PWD = new PasswordHelper().encrypt(password);
		if (md5PWD.equals(user.getPassword())) {
			return ResultModel.defaultSuccess(JWTUtil.sign(username, md5PWD));
		} else {
			throw new UnauthorizedException();
		}
	}*/
}
