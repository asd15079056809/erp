package com.bdqn.erp.service;

import com.bdqn.erp.entity.Permission;
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
public interface PermissionService extends IService<Permission> {

    List<Integer> getRolePermissionIdByRoleId(int roleId);
}
