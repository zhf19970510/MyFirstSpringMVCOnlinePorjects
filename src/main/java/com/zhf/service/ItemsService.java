package com.zhf.service;

import com.zhf.pojo.ItemsCustom;
import com.zhf.pojo.ItemsQueryVo;

import java.util.List;

/**
 * Created on 2020/1/19 0019.
 */
public interface ItemsService {
    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

    ItemsCustom findItemsById(int id)throws Exception;

    void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
}
