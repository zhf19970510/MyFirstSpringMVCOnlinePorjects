package com.zhf.convert;

import org.springframework.core.convert.converter.Converter;

/**
 * @author ZengHongFa
 * @create 2020/1/22 0022 11:12
 */
public class StringTrimConvert implements Converter<String,String> {

    @Override
    public String convert(String source) {
        try{
            if(source!=null){
                source = source.trim();
                if("".equals(source)){
                    return null;
                }
            }
        }catch (Exception e){

        }
        return source;
    }
}
