package com.zhf.mapper;

import com.zhf.pojo.ItemsCustom;
import com.zhf.pojo.ItemsQueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2020/1/19 0019.
 */
public interface ItemsCustomMapper {
    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
