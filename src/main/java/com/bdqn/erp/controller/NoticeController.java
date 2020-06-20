package com.bdqn.erp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.erp.entity.Log;
import com.bdqn.erp.entity.Notice;
import com.bdqn.erp.entity.User;
import com.bdqn.erp.service.LogService;
import com.bdqn.erp.service.NoticeService;
import com.bdqn.erp.utils.Result;
import com.bdqn.erp.vo.JsonResult;
import com.bdqn.erp.vo.LogRecord;
import com.bdqn.erp.vo.LoginUserVo;
import com.bdqn.erp.vo.NoticeVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 熊伟
 * @since 2020-06-15
 */
@RestController
@RequestMapping("/erp/notice")
public class NoticeController {
    @Autowired
    NoticeService noticeService;
    @Autowired
    LogService logService;

    //公告table
    @Cacheable(value = "notice",key = "'notices'")
    @RequestMapping("/notice")
    public Result noticeTable(NoticeVo noticeVo) {
        Page<Notice> page = new Page<>(noticeVo.getPage(), noticeVo.getLimit());
        QueryWrapper<Notice> wrapper = new QueryWrapper<>();
        wrapper.like(!StringUtils.isEmpty(noticeVo.getTitle()), "title", noticeVo.getTitle());
        wrapper.like(!StringUtils.isEmpty(noticeVo.getOpername()), "opername", noticeVo.getOpername());
        wrapper.ge(!StringUtils.isEmpty(noticeVo.getStartTime()), "createtime", noticeVo.getStartTime());
        wrapper.le(!StringUtils.isEmpty(noticeVo.getEndTime()), "createtime", noticeVo.getEndTime());
        wrapper.orderByDesc("createtime");
        noticeService.page(page, wrapper);
        Result result = new Result();
        result.setData(page.getRecords());
        result.setCount(page.getTotal());
        return result;
    }

    //添加公告层
    @Transactional
    @RequestMapping("/addNotice")
    public JsonResult addNotice(Notice notice) {
        LoginUserVo user = (LoginUserVo) SecurityUtils.getSubject().getPrincipal();
        notice.setOpername(user.getUser().getName());
        //日志记录
        Log log = new Log("添加公告", "添加操作", user.getUser().getLoginname(), user.getUser().getId(), user.getUser().getAddress());
        noticeService.save(notice);
        logService.save(log);
        return new JsonResult("success", "添加成功");
    }
    //删除单条公告
    @RequestMapping("/deleteById/{id}")
    public JsonResult  deleteInfo(@PathVariable Integer id,HttpServletRequest request){
          noticeService.removeById(id);
       Log log=  LogRecord.getLog("日志操作","删除日志",request);
         logService.save(log);
          return  new JsonResult("success","删除成功");
    }
    //批量删除公告
    @RequestMapping("/batchDelete")
    public JsonResult deleteInfo(String ids,HttpServletRequest request){
              String s[]=  ids.split(",");
              List<Integer> list =new ArrayList<>();
        for (String s1 : s) {
             list.add(Integer.parseInt(s1));
        }
        noticeService.removeByIds(list);
        Log log= LogRecord.getLog("公告操作","批量删除",request);
        logService.save(log);
        return new JsonResult("成功","批量删除成功");
    }
    //更新公告
    @Cacheable()
    @RequestMapping("/updateNotice")
    public JsonResult updateNotice(Notice notice,HttpServletRequest request){
          noticeService.updateById(notice);
          Log log =LogRecord.getLog("公告操作","更新公告",request);
          logService.save(log);
          return new JsonResult("成功","更新成功");
    }
}

