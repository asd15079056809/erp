package com.bdqn.erp.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

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
 * @since 2020-06-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_permission")
@ApiModel(value="Permission对象", description="")
public class Permission implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "菜单权限编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "所属菜单")
    private Integer pid;

    @ApiModelProperty(value = "权限类型[menu/permission]")
    private String type;

    @ApiModelProperty(value = "菜单权限名称")
    private String title;

    @ApiModelProperty(value = "权限编码[只有type= permission才有  user:view]")
    private String percode;

    @ApiModelProperty(value = "菜单图标")
    private String icon;

    @ApiModelProperty(value = "菜单跳转请求路径")
    private String href;

    @ApiModelProperty(value = "菜单是否展开(0展开，1不展开)")
    private Integer open;

    @ApiModelProperty(value = "排序码")
    private Integer ordernum;

    @ApiModelProperty(value = "状态【0不可用1可用】")
    private Integer available;
    @TableField(exist = false)
    private List<Permission> children;

}
