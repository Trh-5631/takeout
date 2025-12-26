package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from shopper where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    /**
     * 插入商户数据
     * @param dish
     */
    @AutoFill(value = OperationType.INSERT)
    void insert(Dish dish);

    /**
     * 商户分页查询
     * @param dishPageQueryDTO
     * @return
     */
    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 根据主键查询商户
     * @param id
     * @return
     */
    @Select("select * from shopper where id = #{id}")
    Dish getById(Long id);

    /**
     *根据主键删除商户数据
     * @param id
     */
    @Delete("delete from shopper where id = #{id}")
    void deleteById(Long id);

    /**
     * 根据商户id集合批量删除
     * @param ids
     */
    void deleteByIds(List<Long> ids);

    /**
     * 根据商户id动态修改
     * @param dish
     */
    @AutoFill(value = OperationType.UPDATE)
    void update(Dish dish);
    /**
     * 动态条件查询商户
     *
     * @param dish
     * @return
     */
    List<Dish> list(Dish dish);

    /**
     * 根据活动id查询商户
     * @param setmealId
     * @return
     */
    @Select("select a.* from shopper a left join activity_shopper b on a.id = b.dish_id where b.setmeal_id = #{setmealId}")
    List<Dish> getBySetmealId(Long setmealId);

    /**
     * 根据条件统计商户数量
     * @param map
     * @return
     */
    Integer countByMap(Map map);
}
