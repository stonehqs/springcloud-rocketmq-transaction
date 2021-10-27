package com.hqs.chargeorderservice.service;


/**
 * @Description: 订单业务类
 */
public interface ProduceOrderService {

     /**
      * @Description: 下单接口
      *
      */
     int save(int userId, int produceId, int total, int tradeNo);
}
