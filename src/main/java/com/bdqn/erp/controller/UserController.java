package com.bdqn.erp.controller;


import com.bdqn.erp.entity.Log;
import com.bdqn.erp.entity.User;
import com.bdqn.erp.service.LogService;
import com.bdqn.erp.utils.R;
import com.bdqn.erp.vo.LoginUserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.omg.CORBA.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.servlet.function.ServerResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 熊伟
 * @since 2020-06-04
 */
@RestController
@RequestMapping("/erp/user")
public class UserController {
    @Autowired
    LogService logService;
    //登录
    @RequestMapping("/login")
    public R login(String loginname,String loginpwd, HttpServletRequest request) {
        System.out.println(loginname+"---"+loginpwd);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginname,loginpwd);
        try{
            if(!subject.isAuthenticated()){
                subject.login(token);
              LoginUserVo  userVo =  (LoginUserVo) subject.getPrincipal();
                request.getSession().setAttribute("loginuser",userVo.getUser());
                Log log = new Log("用户登录","登陆操作",userVo.getUser().getLoginname(),userVo.getUser().getId(),"127.0.0.1");
                 logService.save(log);
                return R.ok();
            }
            return R.ok();
        }catch (UnknownAccountException e){
            e.printStackTrace();
            return R.error();
        }
    }
}

