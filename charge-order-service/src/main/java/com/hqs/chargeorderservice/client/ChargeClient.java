package com.hqs.chargeorderservice.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: 充值话费服务端
 * name = "product-service"是你调用服务端名称
 *
 */
@FeignClient(name = "product-service")
public interface ChargeClient {

    /**
      * @Title:
      * @Description: 这样组合就相当于http://product-service/api/v1/product/find
      *
      * @throws
      */
    @GetMapping("/api/v1/produce/find")
    String findById(@RequestParam(value = "produceId") int produceId);

}
