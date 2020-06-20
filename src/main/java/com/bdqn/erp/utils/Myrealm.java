package com.bdqn.erp.utils;

import com.bdqn.erp.entity.User;
import com.bdqn.erp.service.UserService;
import com.bdqn.erp.vo.LoginUserVo;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class Myrealm extends AuthorizingRealm {
    @Autowired
    UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
           String username=(String)token.getPrincipal();
        User user = userService.getUserByName(username);
         if(null!=user){
             LoginUserVo loginUserVo = new LoginUserVo(user,null,null);
             ByteSource salt = ByteSource.Util.bytes(user.getSalt());
             SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(loginUserVo,user.getLoginpwd(),salt,this.getName());
             return info;
         }
        return  null;
    }
}
