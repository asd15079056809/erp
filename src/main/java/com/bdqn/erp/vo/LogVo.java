package com.bdqn.erp.vo;

import com.bdqn.erp.entity.Log;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogVo extends Log {
    private Integer page;
    private Integer limit;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date  startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date  endTime;
}
