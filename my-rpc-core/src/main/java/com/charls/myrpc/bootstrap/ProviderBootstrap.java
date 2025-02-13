package com.charls.myrpc.bootstrap;

import com.charls.myrpc.RpcApplication;
import com.charls.myrpc.config.RegistryConfig;
import com.charls.myrpc.config.RpcConfig;
import com.charls.myrpc.model.ServiceMetaInfo;
import com.charls.myrpc.model.ServiceRegisterInfo;
import com.charls.myrpc.registry.LocalRegistry;
import com.charls.myrpc.registry.Registry;
import com.charls.myrpc.registry.RegistryFactory;
import com.charls.myrpc.server.tcp.VertxTcpServer;

import java.util.List;

/**
 * @Author: charls
 * @Description: 服务提供者初始化
 * @Date: 2025/02/13/ 14:58
 * @Version: 1.0
 */
public class ProviderBootstrap {

    /**
     * 初始化
     */
    public static void init(List<ServiceRegisterInfo<?>> serviceRegisterInfoList) {
        // RPC 框架初始化（配置和注册中心）
        RpcApplication.init();
        // 全局配置
        final RpcConfig rpcConfig = RpcApplication.getRpcConfig();

        // 注册服务
        for (ServiceRegisterInfo<?> serviceRegisterInfo : serviceRegisterInfoList) {
            String serviceName = serviceRegisterInfo.getServiceName();
            // 本地注册
            LocalRegistry.register(serviceName, serviceRegisterInfo.getImplClass());

            // 注册服务到注册中心
            RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
            Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
            ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
            serviceMetaInfo.setServiceName(serviceName);
            serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
            serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
            try {
                registry.register(serviceMetaInfo);
            } catch (Exception e) {
                throw new RuntimeException(serviceName + " 服务注册失败", e);
            }
        }

        // 启动服务器
        VertxTcpServer vertxTcpServer = new VertxTcpServer();
        vertxTcpServer.doStart(rpcConfig.getServerPort());
    }

}
