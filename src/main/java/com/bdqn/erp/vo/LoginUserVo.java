package com.bdqn.erp.vo;

import com.bdqn.erp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserVo {
    private User user;
    private List<String> roles;
    private List<String> premissions;
}
