package com.bdqn.erp.service.impl;

import com.bdqn.erp.entity.Role;
import com.bdqn.erp.mapper.RoleMapper;
import com.bdqn.erp.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 熊伟
 * @since 2020-06-22
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Resource
    RoleMapper roleMapper;

    @Override
    public boolean removeById(Integer id) {
          roleMapper.deleteRolePermission(id);
          roleMapper.deleteRoleUser(id);
        return  super.removeById(id);
    }

    @Override
    public boolean saveRolePermission(Integer rid, String ids) throws Exception {
         try{
             roleMapper.deleteRolePermission(rid);
             String[] idList = ids.split(",");
             for (int i = 0; i < idList.length; i++) {
                 baseMapper.saveByRoleAndPermission(rid,idList[i]);
             }
           return true;
         }catch (Exception e){
             e.printStackTrace();
         }
        return false;
    }
}
