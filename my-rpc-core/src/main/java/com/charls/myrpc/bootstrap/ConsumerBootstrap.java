package com.charls.myrpc.bootstrap;

import com.charls.myrpc.RpcApplication;

/**
 * @Author: charls
 * @Description: 服务消费者启动类（初始化）
 * @Date: 2025/02/13/ 15:13
 * @Version: 1.0
 */
public class ConsumerBootstrap {

    /**
     * 初始化
     */
    public static void init() {
        // RPC 框架初始化（配置和注册中心）
        RpcApplication.init();
    }

}
