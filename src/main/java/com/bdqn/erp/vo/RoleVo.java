package com.bdqn.erp.vo;

import com.bdqn.erp.entity.Role;
import lombok.Data;

@Data
public class RoleVo  extends Role {
     private Integer page;
     private Integer limit;
}
