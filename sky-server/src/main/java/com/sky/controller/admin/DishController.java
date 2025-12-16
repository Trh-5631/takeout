package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商户管理
 */
@RestController
@RequestMapping("/admin/dish")
@Api(tags = "商户相关接口")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;

    /**
     * 新增商户
     * @param dishDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增商户")
    public Result save(@RequestBody DishDTO dishDTO){
        log.info("新增商户：{}",dishDTO);
        dishService.saveWithFlavor(dishDTO);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation("商户分页查询")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO){
        log.info("商户分页查询：{}", dishPageQueryDTO);
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 商户删除
     * @param ids
     * @return
     */
    @DeleteMapping
    @ApiOperation("商户批量删除")
    public Result delete(@RequestParam List<Long> ids){
        log.info("商户删除：{}",ids);
        dishService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 根据id查询商户
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询商户")
    public Result<DishVO> getById(@PathVariable Long id){
        log.info("根据id查询商户：{}",id);
        DishVO dishVO = dishService.getByIdWithFlavor(id);
        return Result.success(dishVO);
    }
}
