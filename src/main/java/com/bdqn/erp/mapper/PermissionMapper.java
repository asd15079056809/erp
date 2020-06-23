package com.bdqn.erp.mapper;

import com.bdqn.erp.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 熊伟
 * @since 2020-06-06
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    @Select("select pid from sys_role_permission where rid=#{roleId}")
    List<Integer> getRolePermissionIdByRoleId(int roleId);
}
