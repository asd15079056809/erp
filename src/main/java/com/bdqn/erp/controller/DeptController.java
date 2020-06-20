package com.bdqn.erp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.erp.entity.Dept;
import com.bdqn.erp.service.DeptService;
import com.bdqn.erp.utils.Result;
import com.bdqn.erp.vo.TreeNode;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 熊伟
 * @since 2020-06-16
 */
@RestController
@RequestMapping("/erp/dept")
public class DeptController {
    @Autowired
    DeptService deptService;
    //获取树节点
    @RequestMapping("/getDeptTree")
    public Result deptTree(){
      List<TreeNode> deptTree=  deptService.getTree();
      Result result =new Result();
      result.setData(deptTree);
      return result;
    }

    //获取节点2
    @RequestMapping("/getDeptTree2")
    public Result getNodes(){
        List<TreeNode> list =new ArrayList<>();
        List<Dept> depts= deptService.list();
        depts.forEach(dept -> {
            TreeNode tree =new TreeNode();
            tree.setSpread(dept.getOpen()==0?true:false);
            tree.setTitle(dept.getTitle());
            tree.setPid(dept.getPid());
            tree.setId(dept.getId());
            list.add(tree);
        });
        Result result =new Result();
        result.setData(list);
        return result;
    }

    //获取右侧表格
    @RequestMapping("/getDeptTable")
    public Result  getDepteTable(Integer page,Integer limit,Dept dept){
             Page<Dept> page1 = new Page<>(page,limit);
        QueryWrapper<Dept> wrapper = new QueryWrapper<>();
        wrapper.like(!StringUtils.isEmpty(dept.getTitle()),"title",dept.getTitle());
        wrapper.like(!StringUtils.isEmpty(dept.getAddress()),"address",dept.getAddress());
        wrapper.eq(!StringUtils.isEmpty(dept.getId()),"id",dept.getId());

        deptService.page(page1,wrapper);
        Result result = new Result();
        result.setData(page1.getRecords());
        result.setCount(page1.getTotal());
        return result;
    }
}

