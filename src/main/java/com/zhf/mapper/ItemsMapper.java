package com.zhf.mapper;

import com.zhf.pojo.Items;
import com.zhf.pojo.ItemsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbg.generated Sun Jan 19 16:20:14 CST 2020
     */
    long countByExample(ItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbg.generated Sun Jan 19 16:20:14 CST 2020
     */
    int deleteByExample(ItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbg.generated Sun Jan 19 16:20:14 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbg.generated Sun Jan 19 16:20:14 CST 2020
     */
    int insert(Items record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbg.generated Sun Jan 19 16:20:14 CST 2020
     */
    int insertSelective(Items record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbg.generated Sun Jan 19 16:20:14 CST 2020
     */
    List<Items> selectByExampleWithBLOBs(ItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbg.generated Sun Jan 19 16:20:14 CST 2020
     */
    List<Items> selectByExample(ItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbg.generated Sun Jan 19 16:20:14 CST 2020
     */
    Items selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbg.generated Sun Jan 19 16:20:14 CST 2020
     */
    int updateByExampleSelective(@Param("record") Items record, @Param("example") ItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbg.generated Sun Jan 19 16:20:14 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") Items record, @Param("example") ItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbg.generated Sun Jan 19 16:20:14 CST 2020
     */
    int updateByExample(@Param("record") Items record, @Param("example") ItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbg.generated Sun Jan 19 16:20:14 CST 2020
     */
    int updateByPrimaryKeySelective(Items record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbg.generated Sun Jan 19 16:20:14 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(Items record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbg.generated Sun Jan 19 16:20:14 CST 2020
     */
    int updateByPrimaryKey(Items record);
}