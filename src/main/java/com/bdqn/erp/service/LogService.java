package com.bdqn.erp.service;

import com.bdqn.erp.entity.Log;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 熊伟
 * @since 2020-06-06
 */
public interface LogService extends IService<Log> {

    List<Log> getLog();

    List<Log> getLogs();
}
