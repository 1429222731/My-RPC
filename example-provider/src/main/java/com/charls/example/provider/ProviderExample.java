package com.charls.example.provider;

import com.charls.example.common.service.UserService;
import com.charls.myrpc.RpcApplication;
import com.charls.myrpc.config.RegistryConfig;
import com.charls.myrpc.config.RpcConfig;
import com.charls.myrpc.model.ServiceMetaInfo;
import com.charls.myrpc.registry.LocalRegistry;
import com.charls.myrpc.registry.Registry;
import com.charls.myrpc.registry.RegistryFactory;
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
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动web服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
