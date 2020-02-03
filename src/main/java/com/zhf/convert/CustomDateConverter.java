package com.zhf.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZengHongFa
 * @create 2020/1/22 0022 11:09
 */
public class CustomDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        try{
            return new SimpleDateFormat("yyyy-MM-dd").parse(source);
        }catch (Exception e){

        }
        return null;
    }
}
