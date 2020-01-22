package org.siping.scaffold.tools.controller;

import org.siping.scaffold.tools.exception.NormalException;
import org.siping.scaffold.tools.result.ResultModel;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Siping
 * @Time 2018/3/17 21:45
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResultModel<String> excption(Exception e) {
        if (e instanceof NormalException) {
            return ResultModel.defaultError(e.getMessage());
        }
        return ResultModel.defaultError("这个是非普通业务异常的异常-->" + e.getMessage());
    }
}
