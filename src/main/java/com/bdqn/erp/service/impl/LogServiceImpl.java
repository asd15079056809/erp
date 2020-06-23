package com.bdqn.erp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bdqn.erp.entity.Log;
import com.bdqn.erp.mapper.LogMapper;
import com.bdqn.erp.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 熊伟
 * @since 2020-06-06
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

    @Override
    public List<Log> getLog() {
        List<Integer> list =new ArrayList(Arrays.asList(1,2,3,4));
        QueryWrapper<Log> wrapper =new QueryWrapper<>();
        wrapper.in("id",list);
        List<Log> list2=  baseMapper.getLog(wrapper);
        return list2;
    }

    @Override
    public List<Log> getLogs() {
          Log log =new Log();
          log.setType("登录");
          log.setLoginname("超级");
          QueryWrapper<Log> wrapper =new QueryWrapper<>();
          wrapper.like("type",log.getType());
          wrapper.like("loginname",log.getLoginname());
          List<Log> list=  baseMapper.getLogs(log);
        return list;
    }
}
