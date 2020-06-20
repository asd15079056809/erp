package com.bdqn.erp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bdqn.erp.entity.User;
import com.bdqn.erp.mapper.UserMapper;
import com.bdqn.erp.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 熊伟
 * @since 2020-06-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
         public  User getUserByName(String username){
             QueryWrapper<User> wrapper=new QueryWrapper<>();
             wrapper.eq("loginname",username);
             User user=  baseMapper.selectOne(wrapper);
             return user;
         }
}
