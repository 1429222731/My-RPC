package com.charls.example.provider;

import com.charls.example.common.service.UserService;
import com.charls.myrpc.RpcApplication;
import com.charls.myrpc.registry.LocalRegistry;
import com.charls.myrpc.server.HttpServer;
import com.charls.myrpc.server.VertxHttpServer;

/**
 * @Author: charls
 * @Description: 服务提供者示例
 * @Date: 2025/02/11/ 21:37
 * @Version: 1.0
 */
public class ProviderExample {

    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动web服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
