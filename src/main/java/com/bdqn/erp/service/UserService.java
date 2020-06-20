package com.bdqn.erp.service;

import com.bdqn.erp.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 熊伟
 * @since 2020-06-04
 */
public interface UserService extends IService<User> {
    public  User getUserByName(String username);
}
