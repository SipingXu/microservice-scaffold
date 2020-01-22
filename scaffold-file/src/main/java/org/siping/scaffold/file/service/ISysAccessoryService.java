package org.siping.scaffold.file.service;

import org.siping.scaffold.platform.entity.SysAccessory;
import org.siping.scaffold.tools.result.ResultModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Siping
 */
@FeignClient("boot-service")
public interface ISysAccessoryService {


    /**
     * 文件上传api接口
     * @param accessory 附件信息
     * @return String
     */
    @RequestMapping("sys/accessory/upload")
    ResultModel<String> upload(SysAccessory accessory);

    /**
     * 根据id获取附件
     * @param id 附件id
     * @return accessory
     */
    @RequestMapping("sys/accessory/open")
    ResultModel<SysAccessory> getById(@RequestParam("id")String id);
}
