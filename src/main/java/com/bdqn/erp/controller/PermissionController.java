package com.bdqn.erp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.erp.entity.Permission;
import com.bdqn.erp.service.PermissionService;
import com.bdqn.erp.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 熊伟
 * @since 2020-06-06
 */
@RestController
@RequestMapping("/erp/permission")
public class PermissionController {
    @Autowired
    PermissionService permissionService;
    @RequestMapping("permissionList")
    public Result getMenuNodes(Integer page, Integer limit, Permission permission){
        Page<Permission> page1 =new Page<>(page,limit);
        QueryWrapper<Permission> wrapper = new QueryWrapper<>();
        wrapper.eq("type","permission");
        wrapper.like(!StringUtils.isEmpty(permission.getTitle()),"title",permission.getTitle());
        wrapper.eq(!StringUtils.isEmpty(permission.getPercode()),"percode",permission.getPercode());
        wrapper.eq(!StringUtils.isEmpty(permission.getId()),"pid",permission.getId());
        permissionService.page(page1,wrapper);
        Result result = new Result();
        result.setData(page1.getRecords());
        result.setCount(page1.getTotal());
        return result;
    }
}

