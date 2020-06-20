package com.bdqn.erp.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
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
 * @since 2020-06-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_log")
@ApiModel(value="Log对象", description="")
public class Log implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "日志编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "日志内容")
    private String content;

    @ApiModelProperty(value = "日志操作类型")
    private String type;

    @ApiModelProperty(value = "执行人")
    private String loginname;

    @ApiModelProperty(value = "执行人编号")
    private Integer userid;

    @ApiModelProperty(value = "登录ip")
    private String loginip;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createtime;
    public Log(String content,String type,String loginname,Integer userid,String loginip){
        this.content=content;
        this.type=type;
        this.loginname=loginname;
        this.userid=userid;
        this.loginip=loginip;
    }
    public Log(){}


}
