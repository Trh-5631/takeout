package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishFlavorMapper {
    /**
     * 批量插入备注
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);

    /**
     *查询
     * @param dishId
     */
    @Delete("delete from shopper_msg where dish_id = #{dishId}")
    void deleteByDishId(Long dishId);

    /**
     * 根据商户id集合批量删除备注
     * @param dishIds
     */
    void deleteByDishIds(List<Long> dishIds);

    /**
     * 根据商户id查询备注
     * @param dishId
     * @return
     */
    @Select("select * from shopper_msg where dish_id = #{dishId}")
    List<DishFlavor> getByDishId(Long dishId);
}
