package com.bdqn.erp.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {
    private long count=0;
    private Integer  code=0;
    private Object msg;
    private Object data;
}
