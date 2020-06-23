package com.bdqn.erp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2020-06-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role_user")
@ApiModel(value="RoleUser对象", description="")
public class RoleUser implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "角色编号")
    @TableId(value = "rid", type = IdType.ASSIGN_ID)
    private Integer rid;

    @ApiModelProperty(value = "用户编号")
    private Integer uid;


}
