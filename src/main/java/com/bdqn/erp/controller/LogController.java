package com.bdqn.erp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.erp.entity.Log;
import com.bdqn.erp.service.LogService;
import com.bdqn.erp.utils.R;
import com.bdqn.erp.utils.Result;
import com.bdqn.erp.vo.LogVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 熊伟
 * @since 2020-06-06
 */
@RestController
@RequestMapping("/erp/log")
@Slf4j
public class LogController {
    @Autowired
    LogService logService;
   //分页显示
    @RequestMapping("/getLogTable")
    public Result  getPages(LogVo logVo){
        QueryWrapper wrapper = new QueryWrapper();
         wrapper.like(!StringUtils.isEmpty(logVo.getLoginname()),"loginname",logVo.getLoginname());
         wrapper.eq(!StringUtils.isEmpty(logVo.getType()),"type",logVo.getType());
         wrapper.ge(!StringUtils.isEmpty(logVo.getStartTime()),"createtime",logVo.getStartTime());
         wrapper.le(!StringUtils.isEmpty(logVo.getEndTime()),"createtime",logVo.getEndTime());
         Page<Log> page = new Page<>(logVo.getPage(),logVo.getLimit());
         logService.page(page,wrapper);
          log.info(logVo.getPage()+"..."+logVo.getLimit());
            Result result = new Result();
            result.setCount(page.getTotal());
            result.setData(page.getRecords());
            result.setMsg("除了什么问题");

        return  result;
    }
}

