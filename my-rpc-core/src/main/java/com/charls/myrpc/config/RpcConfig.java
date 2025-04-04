package com.charls.myrpc.config;

import com.charls.myrpc.fault.retry.RetryStrategyKeys;
import com.charls.myrpc.fault.tolerant.TolerantStrategyKeys;
import com.charls.myrpc.loadbalancer.LoadBalancerKeys;
import com.charls.myrpc.serializer.SerializerKeys;
import lombok.Data;

/**
 * @Author: charls
 * @Description:RPC 框架全局配置
 * @Date: 2025/02/11/ 21:18
 * @Version: 1.0
 */
@Data
public class RpcConfig {

    /**
     * 名称
     */
    private String name = "my-rpc";

    /**
     * 版本号
     */
    private String version = "1.0";

    /**
     * 服务器主机名
     */
    private String serverHost = "localhost";

    /**
     * 服务器端口号
     */
    private Integer serverPort = 8080;

    /**
     * 模拟调用
     */
    private boolean mock = false;

    /**
     * 序列化器
     */
    private String serializer = SerializerKeys.JDK;

    /**
     * 负载均衡器
     */
    private String loadBalancer = LoadBalancerKeys.ROUND_ROBIN;

    /**
     * 重试策略
     */
    private String retryStrategy = RetryStrategyKeys.NO;

    /**
     * 容错策略
     */
    private String tolerantStrategy = TolerantStrategyKeys.FAIL_FAST;

    /**
     * 注册中心配置
     */
    private RegistryConfig registryConfig = new RegistryConfig();

}
