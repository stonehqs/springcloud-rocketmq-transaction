package com.has.phonechargeservice.service.impl;


import com.has.phonechargeservice.model.Produce;
import com.has.phonechargeservice.service.ChargeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 商品模块实现类
 *
 *
 * @date 2019/7/16 下午10:05
 */
@Slf4j
@Service
public class ChargeServiceImpl implements ChargeService {

    private static final Map<Integer, Produce> daoMap = new HashMap<>();
    private static final Map<Integer, Integer> tradeMap = new ConcurrentHashMap<>();

    /**
     * 模拟数据库商品数据
     */
    static {
        Produce p1 = new Produce(1, "充值卡100元", 100, 10);
        Produce p2 = new Produce(2, "充值卡200元", 200, 19);
        Produce p3 = new Produce(3, "充值卡500元", 500, 90);

        daoMap.put(p1.getProduceId(), p1);
        daoMap.put(p2.getProduceId(), p2);
        daoMap.put(p3.getProduceId(), p3);
    }


    @Override
    public Produce findById(int id) {
        return daoMap.get(id);
    }

    @Override
    public void updateStore(int produceId, int store, String key, int tradeNo) throws Exception {
        Produce produce = daoMap.get(produceId);

        //已经下过订单，无需处理，多实例环境中需要针对这块做处理，采用redis中间件处理也可以。
        if (tradeMap.containsKey(tradeNo)) {
            return;
        }

        // 如果实际库存小于库存 那么需要把这条数据记录到一张专门用于记录分布式事务的表，通过这个key当业务逻辑保证事务最终一致性
        if (produce.getStore() - store < 0) {
            /**
             * TODO 首先实际开发 不可能到这里才判断库存是否不足，而是下订单那边就确定好库存是否充足
             * 因为RocketMQ是最终一致性事务，不可能这边异常那边确已经告知用户下单正常，最后为了保证事务一致性在去修改这个订单为失败，用户会懵逼的
             */
            //模拟保存MQ异常表 用于人工处理 保证事务一致性
            log.info("库存不足，扣减失败。商品ID = {},商品当前库存 = {},所需库存 = {}，分布式事务key = {}", produceId, produce.getStore(), store, key);

            throw new Exception("库存不足，更新库存失败");
        }

        //多实例环境需要进行处理，避免造成多减库存
        Integer left = produce.getStore();
        produce.setStore(left - store);
        tradeMap.put(tradeNo, store);

        log.info("更新库存成功。商品ID = {},商品当前库存 = {},销售库存 = {}，分布式事务key = {}", produceId, produce.getStore(), store, key);

        log.info("===商品模块=== 本地事务执行成功,商品库存扣除成功");
    }
}
