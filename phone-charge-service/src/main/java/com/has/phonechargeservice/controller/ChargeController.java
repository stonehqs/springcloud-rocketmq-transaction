package com.has.phonechargeservice.controller;


import com.alibaba.fastjson.JSON;
import com.has.phonechargeservice.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @Description: 商品服务对外提供接口
 * @date 2019/7/12 下午12:43
 */
@RestController
@RequestMapping("/api/v1/produce")
public class ChargeController {

    @Autowired
    private ChargeService chargeService;

    /**
     * 根据主键ID获取商品
     */
    @GetMapping("/find")
    public String findById(@RequestParam(value = "produceId") int produceId) {
        return JSON.toJSONString(chargeService.findById(produceId));

    }

}
