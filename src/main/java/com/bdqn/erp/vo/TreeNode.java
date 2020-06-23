package com.bdqn.erp.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {
     private Integer id;
     @JsonProperty(value = "parentId")
     private Integer pid;
     private String title;
     private String icon;
     private Boolean spread;
     private String href;
     private List<TreeNode> children =new ArrayList<>();
     private String checkArr ="0";
}
