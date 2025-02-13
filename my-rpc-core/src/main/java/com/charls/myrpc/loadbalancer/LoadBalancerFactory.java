package com.charls.myrpc.loadbalancer;

import com.charls.myrpc.spi.SpiLoader;

/**
 * @Author: charls
 * @Description: 负载均衡器工厂（工厂模式，用于获取负载均衡器对象）
 * @Date: 2025/02/13/ 11:20
 * @Version: 1.0
 */
public class LoadBalancerFactory {

    static {
        SpiLoader.load(LoadBalancer.class);
    }

    /**
     * 默认负载均衡器
     */
    private static final LoadBalancer DEFAULT_LOAD_BALANCER  = new RoundRobinLoadBalancer();

    /**
     * 获取实例
     * @param key
     * @return
     */
    public static LoadBalancer getInstance(String key) {
        return SpiLoader.getInstance(LoadBalancer.class, key);
    }
}
