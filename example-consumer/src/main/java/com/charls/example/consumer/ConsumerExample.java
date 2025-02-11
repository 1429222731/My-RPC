package com.charls.example.consumer;

import com.charls.myrpc.config.RpcConfig;
import com.charls.myrpc.utils.ConfigUtils;

/**
 * @Author: charls
 * @Description: 服务消费者示例
 * @Date: 2025/02/11/ 21:33
 * @Version: 1.0
 */
public class ConsumerExample {

    public static void main(String[] args) {
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpc);
    }
}
