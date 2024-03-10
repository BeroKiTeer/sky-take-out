package com.sky.controller.user;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import com.sky.result.Result;
import com.sky.service.ShoppingCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/shoppingCart")
@Slf4j
@Api(tags = "C端购物车相关接口")
public class ShoppingCartController {
    /**
     * 添加商品到购物车
     * @param shoppingCartDTO
     * @return
     */
    @ApiOperation("添加商品到购物车")
    @PostMapping("add")
    public Result add(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        log.info("添加商品到购物车：{}", shoppingCartDTO);
        shoppingCartService.addShoppingCart(shoppingCartDTO);
        return Result.success();
    }
    @GetMapping("/list")
    @ApiOperation("获取购物车列表")
    public Result<List<ShoppingCart>>list() {
        List<ShoppingCart> list = shoppingCartService.showShoppingCart();
        return Result.success(list);
    }

    @Autowired
    private ShoppingCartService shoppingCartService;
}