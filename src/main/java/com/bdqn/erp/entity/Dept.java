package com.bdqn.erp.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
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
 * @since 2020-06-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_dept")
@ApiModel(value="Dept对象", description="")
public class Dept implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "部门编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "父级部门编号")
    private Integer pid;

    @ApiModelProperty(value = "父级部门名称")
    private String title;

    @ApiModelProperty(value = "是否展开(0-展开,1-不展开)")
    private Integer open;

    @ApiModelProperty(value = "部门地址")
    private String address;
     @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createtime;

    @ApiModelProperty(value = "备注")
    private String remark;
    @TableField(exist = false)
    private List<Dept> child;

}
