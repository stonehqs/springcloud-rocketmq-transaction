package com.has.phonechargeservice.service;


import com.has.phonechargeservice.model.Produce;

/**
  * @ClassName: ProduceService
  * @Description:  获取商品信息相关接口
  *
  * @date 2019/7/12 下午12:37
  */
public interface ChargeService {

    /**
     *  根据商品ID查找商品
     */
    Produce findById(int produceId);

    /**
     * 更新库存
     * @param produceId 商品ID
     * @param store     销售库存数量
     */
    /**
     * 更新库存
     * @param key 唯一值 分布式事务用
     * @param produceId 商品ID
     * @param store     销售库存数量
     * @param tradeNo   订单号
     */
    void updateStore(int produceId, int store, String key, int tradeNo) throws Exception;
}
