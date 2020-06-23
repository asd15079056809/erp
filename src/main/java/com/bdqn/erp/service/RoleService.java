package com.bdqn.erp.service;

import com.bdqn.erp.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 熊伟
 * @since 2020-06-22
 */
public interface RoleService extends IService<Role> {
        boolean  removeById(Integer id);

    boolean saveRolePermission(Integer rid, String ids) throws Exception;
}
