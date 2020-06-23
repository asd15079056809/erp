package com.bdqn.erp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.bdqn.erp.entity.Log;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 熊伟
 * @since 2020-06-06
 */
public interface LogMapper extends BaseMapper<Log> {

    List<Log> getLog(@Param(Constants.WRAPPER) QueryWrapper<Log> wrapper);

    List<Log> getLogs(Log log);
}
