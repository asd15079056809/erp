package com.bdqn.erp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.erp.entity.Notice;
import com.bdqn.erp.utils.R;
import com.bdqn.erp.vo.NoticeVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/sys")
public class SysController {
    @RequestMapping("/index")
    public String  indexs(){
        return "index";
    }
    @RequestMapping("/main")
    public String mains(){
        return "main";
    }
    @RequestMapping("/logTable")
    public String logTable(){
        return "log/logTable";
    }
    //公告管理
    @RequestMapping("/notice")
    public String noticeManager(){
        return "notice/noticeManager";
    }
    //去部门管理系统
    @RequestMapping("/toDeptManager")
    public String todept(){
        return "dept/deptManager";
    }
    @RequestMapping("/toDeptLeft")
    public String  tolefet(){
        return "dept/left";
    }
    @RequestMapping("/toDeptRight")
    public String  toright(){
        return "dept/right";
    }

    //菜单管理系统

    @RequestMapping("toMenuManager")
    public String toMenuManager(){
        return "menu/menuManager";
    }
    @RequestMapping("toMenuLeft")
    public String toLeftMenu(){
        return "menu/left";
    }
    @RequestMapping("toMenuRight")
    public String toMenuRight(){
        return  "menu/right";
    }

    //权限管理
    @RequestMapping("toPermissionManager")
    public String  toPermission(){
        return "permission/permissionManager";
    }
    @RequestMapping("toPermissionLeft")
    public String  topermissionLeft(){
        return "permission/left";
    }
    @RequestMapping("toPermissionRight")
    public String toPermissionRight(){
        return "permission/right";
    }
}
