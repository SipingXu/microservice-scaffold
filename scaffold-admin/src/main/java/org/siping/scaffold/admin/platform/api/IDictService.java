package org.siping.scaffold.admin.platform.api;

import com.baomidou.mybatisplus.plugins.Page;
import org.siping.scaffold.platform.entity.PtDict;
import org.siping.scaffold.tools.result.ResultModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Siping
 * @Time 2018/5/6 20:57
 */
@FeignClient("boot-service")
public interface IDictService {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping(value = "pt/dict/get-by-id",method = RequestMethod.GET)
    ResultModel<PtDict> getById(@RequestParam("id") String id);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @RequestMapping(value = "pt/dict/del-by-id",method = RequestMethod.POST)
    ResultModel<String> delById(@RequestParam("id") String id);

    /**
     * 分页查询
     * @param page
     * @return
     */
    @RequestMapping(value = "pt/dict/query-page",method = RequestMethod.POST)
    ResultModel<Page<PtDict>> queryPage(Page<PtDict> page);

    /**
     * 新增或修改
     * @param dict
     * @return
     */
    @RequestMapping(value = "pt/dict/save-or-update",method = RequestMethod.POST)
    ResultModel<String> saveOrUpdate(PtDict dict);
}
