package com.zhf.controller;

import com.zhf.pojo.ItemsCustom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZengHongFa
 * @create 2020/1/22 0022 18:28
 */
@Controller
public class JsonTestController {
    // 请求JSON，响应JSON
    @RequestMapping("/requestJson")
    public @ResponseBody
    ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom)throws Exception{
        return itemsCustom;
    }

    // 请求key/value，响应JSON
    @RequestMapping("/responseJson")
    public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom){
        return itemsCustom;
    }
}
