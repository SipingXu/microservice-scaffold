package org.siping.scaffold.es.service;

import org.siping.scaffold.es.Entity;
import org.siping.scaffold.tools.result.ResultModel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: 朱建柯
 * Date: 2019/2/13
 * Time: 9:44
 */
public interface IDemoService {

    /**
     * 保存
     *
     * @param entity
     * @return
     */
    ResultModel save(@RequestBody Entity entity);

    /**
     * 搜索
     *
     * @param searchContent
     * @return
     */
    ResultModel search(@RequestParam("searchContent") String searchContent);

}
