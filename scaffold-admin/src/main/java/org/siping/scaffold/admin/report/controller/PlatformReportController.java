package org.siping.scaffold.admin.report.controller;

import org.siping.scaffold.admin.platform.api.ISysUserService;
import org.siping.scaffold.tools.controller.BaseController;
import org.siping.scaffold.tools.result.ResultModel;
import org.siping.scaffold.vo.ChartVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Siping
 * @date 2018/5/3 9:34
 * @description
 */
@Controller
@RequestMapping("report/platform")
public class PlatformReportController extends BaseController {

	@Resource
	private ISysUserService sysUserService;

	@RequestMapping("user-report")
	public String userReport(){
		return "report/platform/user-report";
	}

	@ResponseBody
	@RequestMapping("login-count")
	public ResultModel<List<ChartVO>> loginCount(){
		return sysUserService.loginCount();
	}
}
