package org.siping.scaffold.admin.config.service;

import org.siping.scaffold.tools.result.ResultModel;

import java.util.List;

/**
 * @author Siping
 */
public interface IPermissionService {

    ResultModel<List<String>> getPermissions(String userId);
}
