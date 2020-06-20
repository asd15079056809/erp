package com.bdqn.erp.service;

import com.bdqn.erp.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bdqn.erp.vo.TreeNode;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 熊伟
 * @since 2020-06-16
 */
public interface DeptService extends IService<Dept> {

    List<TreeNode> getTree();
}
