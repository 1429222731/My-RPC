package com.charls.myrpc.loadbalancer;

/**
 * @Author: charls
 * @Description: 负载均衡器键名常量
 * @Date: 2025/02/13/ 11:19
 * @Version: 1.0
 */
public interface LoadBalancerKeys {

    /**
     * 轮询
     */
    String ROUND_ROBIN = "roundRobin";

    /**
     * 随机
     */
    String RANDOM = "random";

    /**
     * 一致性哈希
     */
    String CONSISTENT_HASH = "consistentHash";

}
