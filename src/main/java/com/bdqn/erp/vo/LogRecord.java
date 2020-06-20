package com.bdqn.erp.vo;

import com.bdqn.erp.entity.Log;
import com.bdqn.erp.entity.User;
import com.bdqn.erp.utils.IpUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

public class LogRecord {
     public static Log getLog(String content, String type, HttpServletRequest request){
      LoginUserVo loginUserVo =(LoginUserVo)    SecurityUtils.getSubject().getPrincipal();
        User user =loginUserVo.getUser();
        Log log =new Log(content,type,user.getLoginname(),user.getId(),IpUtil.getIpAddr(request));
        return  log;
     }
}
