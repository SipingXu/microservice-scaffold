package org.siping.scaffold.admin.platform.api;

import org.siping.scaffold.tools.result.ResultModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("boot-service")
public interface ISysPermissionService {

    @RequestMapping(value = "sys/role/get-by-user",method = RequestMethod.GET)
    ResultModel<List<String>> getRoles(@RequestParam("userId") String userId);

    @RequestMapping(value = "sys/role/permission/get-all",method = RequestMethod.GET)
    ResultModel<List<String>> getPermissions(@RequestParam("userId") String userId);


}
