package com.bdqn.erp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 熊伟
 * @since 2020-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "登录名称")
    private String loginname;

    @ApiModelProperty(value = "登录密码")
    private String loginpwd;

    @ApiModelProperty(value = "用户真实姓名")
    private String name;

    @ApiModelProperty(value = "用户地址")
    private String address;

    @ApiModelProperty(value = "性别(0男1女)")
    private Integer sex;

    @ApiModelProperty(value = "所在部门编号")
    private Integer deptid;

    @ApiModelProperty(value = "入职日期")
    private Date hiredate;

    @ApiModelProperty(value = "所属领导")
    private Integer mgr;

    @ApiModelProperty(value = "用户类型[0超级管理员1，管理员，2普通用户]")
    private Integer type;

    @ApiModelProperty(value = "头像地址")
    private String imgpath;

    @ApiModelProperty(value = "是否可用(0否1可)")
    private Integer available;

    @ApiModelProperty(value = "密码加密盐值")
    private String salt;

    @ApiModelProperty(value = "备注")
    private String remark;


}
