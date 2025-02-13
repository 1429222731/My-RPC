package com.charls.myrpc.fault.retry;

import com.charls.myrpc.spi.SpiLoader;

/**
 * @Author: charls
 * @Description: 重试策略工厂（用于获取重试器对象）
 * @Date: 2025/02/13/ 12:34
 * @Version: 1.0
 */
public class RetryStrategyFactory {

    static {
        SpiLoader.load(RetryStrategy.class);
    }

    /**
     * 默认重试器
     */
    private static final RetryStrategy DEFAULT_RETRY_STRATEGY = new NoRetryStrategy();

    /**
     * 获取实例
     *
     * @param key
     * @return
     */
    public static RetryStrategy getInstance(String key) {
        return SpiLoader.getInstance(RetryStrategy.class, key);
    }

}
