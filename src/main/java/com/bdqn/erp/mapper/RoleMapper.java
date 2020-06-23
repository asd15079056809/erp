package com.bdqn.erp.mapper;

import com.bdqn.erp.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 熊伟
 * @since 2020-06-22
 */
public interface RoleMapper extends BaseMapper<Role> {
        @Delete("delete from sys_role_permission where rid=#{id}")
        boolean   deleteRolePermission(Integer id);
        @Delete("delete from sys_role_user where rid=#{id}")
        boolean deleteRoleUser(Integer id);
         @Insert("insert into sys_role_permission values(#{rid},#{pid})")
        void saveByRoleAndPermission(@Param("rid") Integer rid,@Param("pid") String pid);
}
