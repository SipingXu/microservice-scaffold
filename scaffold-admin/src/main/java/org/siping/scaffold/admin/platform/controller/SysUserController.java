package org.siping.scaffold.admin.platform.controller;

import com.baomidou.mybatisplus.plugins.Page;
import org.siping.scaffold.admin.platform.api.IRoleService;
import org.siping.scaffold.admin.platform.api.ISysUserService;
import org.siping.scaffold.platform.entity.SysRole;
import org.siping.scaffold.platform.entity.SysUser;
import org.siping.scaffold.tools.controller.BaseController;
import org.siping.scaffold.tools.result.LayPage;
import org.siping.scaffold.tools.result.ResultModel;
import org.siping.scaffold.tools.shiro.utils.PasswordHelper;
import org.siping.scaffold.tools.shiro.utils.PrincipalUtils;
import org.siping.scaffold.tools.util.Constants;
import org.siping.scaffold.tools.util.FileUtil;
import org.siping.scaffold.tools.util.StringUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author Siping
 */
@Controller
@RequestMapping("sys/user")
public class SysUserController extends BaseController {

    @Resource
    private ISysUserService sysUserService;

    @Resource
    private IRoleService roleService;

    @RequestMapping("to-page")
    public String toPage() {
        return "platform/user/list";
    }

    @RequestMapping("to-edit")
    @RequiresPermissions(value = {"sys:user:add", "sys:user:edit"}, logical = Logical.OR)
    public String toEdit(@RequestParam(name = "id", required = false) String id, Model model) {
        SysUser user = sysUserService.getById(id).getData();
        if (user == null) {
            user = new SysUser();
        }
        model.addAttribute("user", user);

        List<SysRole> roles = roleService.queryList(new SysRole()).getData();
        model.addAttribute("roles", roles);
        return "platform/user/edit";
    }

    @ResponseBody
    @RequestMapping("save-or-update")
    @RequiresPermissions(value = {"sys:user:add", "sys:user:edit"}, logical = Logical.OR)
    public ResultModel<String> save(@Valid SysUser sysUser, BindingResult result) {
        this.validError(result);

        SysUser currentUser = (SysUser) PrincipalUtils.getCurrentUser();

        if (StringUtil.isBlank(sysUser.getId())) {
            sysUser.setCreateTime(new Date());
            sysUser.setCreateUser(currentUser.getId());
            sysUser.setDisabled(Constants.NEGATIVE);
            sysUser.setIsDel(Constants.NEGATIVE);
            String pwd = StringUtil.isBlank(sysUser.getPassword()) ? SysUser.DEFAULT_PWD : sysUser.getPassword();
            sysUser.setPassword(new PasswordHelper().encrypt(pwd));
            sysUser.setLocked(Constants.NEGATIVE);
        }
        return sysUserService.saveOrUpdate(sysUser);
    }

    @ResponseBody
    @RequestMapping("query-page")
    public LayPage<SysUser> queryPage(Page<SysUser> page) {
        return this.getLayPage(sysUserService.queryPage(page));
    }

    @ResponseBody
    @RequestMapping("del")
    @RequiresPermissions("sys:user:del")
    public ResultModel<String> del(@RequestParam("id") String id) {
        return sysUserService.deleteById(id);
    }

    @RequestMapping("detail")
    public String detail(@RequestParam("id") String id, Model model) {
        SysUser user = sysUserService.getById(id).getData();
        model.addAttribute("user", user);
        return "platform/user/detail";
    }

    @RequestMapping("export")
    public void export(SysUser user, HttpServletResponse response) {
        List<SysUser> list = sysUserService.all(user).getData();
        FileUtil.exportExcel(list, "用户统计", "用户统计", SysUser.class, "user.xls", response);
    }
}
