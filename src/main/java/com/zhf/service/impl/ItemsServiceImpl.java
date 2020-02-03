package com.zhf.service.impl;

import com.zhf.mapper.ItemsCustomMapper;
import com.zhf.mapper.ItemsMapper;
import com.zhf.pojo.Items;
import com.zhf.pojo.ItemsCustom;
import com.zhf.pojo.ItemsQueryVo;
import com.zhf.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2020/1/19 0019.
 */
@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsCustomMapper itemsCustomMapper;

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
        System.out.println("可以到serviceImpl方法中");
        return itemsCustomMapper.findItemsList(itemsQueryVo);
    }

    @Override
    public ItemsCustom findItemsById(int id) throws Exception {
        Items items = itemsMapper.selectByPrimaryKey(id);
        ItemsCustom itemsCustom = new ItemsCustom();
        // 将items属性的值拷贝到itemsCustom
        BeanUtils.copyProperties(items,itemsCustom);

        return itemsCustom;
    }

    @Override
    public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception {
        //写业务代码
        //对于关键业务数据进行非空校验
        if(id==null){
            //抛出异常，提示调用接口的用户，id不能为空
        }
        itemsMapper.updateByPrimaryKey(itemsCustom);
    }
}
