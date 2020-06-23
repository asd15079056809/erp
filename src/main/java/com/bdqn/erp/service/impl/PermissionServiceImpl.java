package com.bdqn.erp.service.impl;

import com.bdqn.erp.entity.Permission;
import com.bdqn.erp.mapper.PermissionMapper;
import com.bdqn.erp.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 熊伟
 * @since 2020-06-06
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Override
    public List<Integer> getRolePermissionIdByRoleId(int roleId) {
        List<Integer> pids = baseMapper.getRolePermissionIdByRoleId(roleId);
        return pids;
    }
}
