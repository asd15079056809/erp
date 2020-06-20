package com.bdqn.erp.utils;

import org.springframework.core.convert.converter.Converter;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataFormat implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date =null;
        try {
           date= format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  date;
    }
}
