package com.bdqn.erp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.erp.entity.Permission;
import com.bdqn.erp.service.PermissionService;
import com.bdqn.erp.utils.R;
import com.bdqn.erp.utils.Result;
import com.bdqn.erp.vo.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    PermissionService permissionService;
    @RequestMapping("/getMenu")
    public R  getMenus(){
        QueryWrapper<Permission> wrapper=new QueryWrapper<>();
        wrapper.eq("type","menu");
        List<Permission> list= permissionService.list(wrapper);
         List<Permission> menus=  list.stream().filter(permission -> {
            return permission.getPid()==1;
        }).map(permission -> {
            permission.setChildren(getChildren(list,permission));
            return permission;
        }).collect(Collectors.toList());
        return R.ok().data("menus",menus);
    }
    public  List<Permission> getChildren(List<Permission> permissions,Permission p){
            List<Permission> list=permissions.stream().filter(permission -> {
               return permission.getPid()==p.getId();
           }).map(permission -> {
               permission.setChildren(getChildren(permissions,permission));
               return permission;
           }).collect(Collectors.toList());
            return list;
    }

    //获取菜单节点
    @RequestMapping("getRightTable")
    public Result getMenuNodes(Integer page,Integer limit,Permission permission){
        Page<Permission> page1 =new Page<>(page,limit);
        QueryWrapper<Permission> wrapper = new QueryWrapper<>();
         wrapper.eq("type","menu");
         wrapper.like(!StringUtils.isEmpty(permission.getTitle()),"title",permission.getTitle());
         wrapper.eq(!StringUtils.isEmpty(permission.getId()),"id",permission.getId());
         permissionService.page(page1,wrapper);
         Result result = new Result();
             result.setData(page1.getRecords());
             result.setCount(page1.getTotal());
         return result;
    }
    @RequestMapping("getLeftNodes")
    public Result getLeftNodes(){
         List<TreeNode> nodes =new ArrayList<>();
         QueryWrapper<Permission> wrapper = new QueryWrapper<>();
         wrapper.eq("type","menu");
        List<Permission> list=   permissionService.list(wrapper);
         list.forEach(m->{
              TreeNode tree = new TreeNode();
               tree.setSpread(m.getOpen()==0?true:false);
               tree.setId(m.getId());
               tree.setPid(m.getPid());
               tree.setTitle(m.getTitle());
               nodes.add(tree);
         });
         Result result = new Result();
         result.setData(nodes);
         return result;
    }
}
