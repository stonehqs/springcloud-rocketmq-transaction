package com.has.phonechargeservice.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


/**
 * @Description: 连接RocketMQ服务器实体
 *
 *
 * @date 2021/10/26 下午11:30
 */
@Data
@Configuration
public class Jms {

    /**
     * 配置中心读取 服务器地址
     */
    @Value("${name_server}")
    private String nameServer;

    /**
     * 配置中心读取 主题
     */
    @Value("${order_topic}")
    private String orderTopic;

}
