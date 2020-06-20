package com.bdqn.erp.service.impl;

import com.bdqn.erp.entity.Dept;
import com.bdqn.erp.mapper.DeptMapper;
import com.bdqn.erp.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bdqn.erp.vo.TreeNode;
import org.springframework.stereotype.Service;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 熊伟
 * @since 2020-06-16
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

    @Override
    public List<TreeNode> getTree() {
        //先查出所有的depte
        List<Dept> dept = baseMapper.selectList(null);
        List<TreeNode> nodes = new ArrayList<>();
        dept.forEach(d -> {
            TreeNode tree = new TreeNode();
            tree.setSpread(d.getOpen() == 0 ? true : false);
            tree.setId(d.getId());
            tree.setPid(d.getPid());
            tree.setTitle(d.getTitle());
            nodes.add(tree);
        });
         List<TreeNode> treeNodeList=    nodes.stream().filter(d -> {
            return d.getPid() == 0;
        }).map(d -> {
            d.setChildren(getChild(nodes, d));
            return d;
        }).collect(Collectors.toList());
        return  treeNodeList;
    }

    //给有child的部门子节点
    public List<TreeNode> getChild(List<TreeNode> list, TreeNode d) {
        List<TreeNode> nodeList = list.stream().filter(trees -> {
            return trees.getPid() == d.getId();
        }).map(trees -> {
            trees.setChildren(getChild(list, trees));
            return trees;
        }).collect(Collectors.toList());
        return nodeList;

    }
}
