package com.sky.service;

import com.sky.dto.DishDTO;

public interface DishService {

    /**
     * 新增商户和可接受备注
     * @param dishDTO
     */
    public void saveWithFlavor(DishDTO dishDTO);
}
