package com.bdqn.erp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.erp.entity.Permission;
import com.bdqn.erp.entity.Role;
import com.bdqn.erp.service.PermissionService;
import com.bdqn.erp.service.RolePermissionService;
import com.bdqn.erp.service.RoleService;
import com.bdqn.erp.utils.Result;
import com.bdqn.erp.vo.JsonResult;
import com.bdqn.erp.vo.RoleVo;
import com.bdqn.erp.vo.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 熊伟
 * @since 2020-06-22
 */
@RestController
@RequestMapping("/erp/role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @Autowired
    RolePermissionService rolePermissionService;
    @Autowired
    PermissionService permissionService;

    @RequestMapping("roleList")
    public Result roleList(RoleVo roleVo) {
        Page<Role> pages = new Page<Role>(roleVo.getPage(), roleVo.getLimit());
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.eq(!StringUtils.isEmpty(roleVo.getRolecode()), "rolecode", roleVo.getRolecode());
        wrapper.like(!StringUtils.isEmpty(roleVo.getRolename()), "rolename", roleVo.getRolename());
        roleService.page(pages, wrapper);
        Result result = new Result();
        result.setData(pages.getRecords());
        result.setCount(pages.getTotal());
        return result;
    }

    //添加角色
    @RequestMapping("/addRole")
    public JsonResult addRole(Role role) {
        roleService.save(role);
        return new JsonResult("success", "添加成功");
    }

    //更新角色
    @RequestMapping("/updateRole")
    public JsonResult update(Role role) {
        roleService.updateById(role);
        return new JsonResult("success", "更新成功");
    }

    //单个删除角色
    @RequestMapping("deleteRole")
    public JsonResult deleteRole(Integer id) {
        roleService.removeById(id);
        return new JsonResult("success", "删除成功");
    }

    //获取角色选择权限树节点
    @RequestMapping("getPermissionNodes")
    public Result getPermissionNodes(int roleId) {
        QueryWrapper<Permission> wrapper = new QueryWrapper<>();
        List<Permission> permissions = permissionService.list();
        //通过角色id获取权限id
        List<Integer> permisssionIds = permissionService.getRolePermissionIdByRoleId(roleId);
        List<Permission> currentPermission = new ArrayList<>();
        if (!StringUtils.isEmpty(permisssionIds) && permisssionIds.size() > 0) {
            wrapper.in("id", permisssionIds);
            currentPermission = permissionService.list(wrapper);
        }
        List<TreeNode> trees = new ArrayList<>();
        for (Permission permission : permissions) {
            String checkArr = "0";

            for (Permission permission1 : currentPermission) {
                if (permission.getId() == permission1.getId()) {
                    checkArr = "1";
                    break;
                }

            }
            TreeNode tree = new TreeNode();
            tree.setTitle(permission.getTitle());
            tree.setPid(permission.getPid());
            tree.setId(permission.getId());
            tree.setSpread((permission.getOpen() == null || permission.getOpen() == 0) ? true : false);
            tree.setCheckArr(checkArr);
            trees.add(tree);
        }
        Result result = new Result();
        result.setData(trees);
        return result;
    }

    //分配权限
    @RequestMapping("allotRolePermission")
    public JsonResult allot(Integer rid, String ids) {
        try {
            boolean flag = roleService.saveRolePermission(rid, ids);
            if (flag) {
                return new JsonResult("success", "分配权限成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JsonResult("success", "分配失败");

    }
}

