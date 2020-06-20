package com.bdqn.erp.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R {
    private int code;
    private String msg;
    private int count;
    private Map<String,Object> data=new HashMap<>();
    private R(){}
    public static R ok(){
         R r = new R();
        r.setCode(20000);
        r.setMsg("成功");
        return r;
    }
    public static R error(){
        R r = new R();
        r.setMsg("失败");
        r.setCode(20001);
        return r;
    }
    public R  data(String key,Object val){
         this.data.put(key,val);
         return this;
    }
    public R data(Map<String,Object> map){
        this.setData(map);
        return this;
    }
}
