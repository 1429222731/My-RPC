package com.charls.myrpc;

import com.charls.myrpc.config.RegistryConfig;
import com.charls.myrpc.config.RpcConfig;
import com.charls.myrpc.constant.RpcConstant;
import com.charls.myrpc.registry.Registry;
import com.charls.myrpc.registry.RegistryFactory;
import com.charls.myrpc.utils.ConfigUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: charls
 * @Description: RPC 框架应用
 * 相当于 holder，存放了项目全局用到的变量。双检锁单例模式实现
 * @Date: 2025/02/11/ 21:24
 * @Version: 1.0
 */
@Slf4j
public class RpcApplication {

    private static volatile RpcConfig rpcConfig;

    /**
     * 框架初始化，支持传入自定义配置
     * @param newRpcConfig
     */
    public static void init(RpcConfig newRpcConfig) {
        rpcConfig = newRpcConfig;
        log.info("rpc init, config = {}", newRpcConfig.toString());
        // 注册中心初始化
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        registry.init(registryConfig);
        log.info("registry init, config = {}", registryConfig);

        // 创建并注册 Shutdown Hook，JVM 退出时执行操作
        Runtime.getRuntime().addShutdownHook(new Thread(registry::destroy));
    }

    /**
     * 初始化
     */
    public static void init() {
        RpcConfig newRpcConfig;
        try {
            newRpcConfig = ConfigUtils.loadConfig(RpcConfig.class, RpcConstant.DEFAULT_CONFIG_PREFIX);
        } catch (Exception e) {
            // 配置加载失败，使用默认值
            newRpcConfig = new RpcConfig();
        }
        init(newRpcConfig);
    }

    /**
     * 获取配置
     *
     * @return
     */
    public static RpcConfig getRpcConfig() {
        if (rpcConfig == null) {
            synchronized (RpcApplication.class) {
                if (rpcConfig == null) {
                    init();
                }
            }
        }
        return rpcConfig;
    }
}
