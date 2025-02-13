package com.charls.myrpc.fault.tolerant;

import com.charls.myrpc.spi.SpiLoader;

/**
 * @Author: charls
 * @Description: 容错策略工厂（工厂模式，用于获取容错策略对象）
 * @Date: 2025/02/13/ 13:02
 * @Version: 1.0
 */
public class TolerantStrategyFactory {

    static {
        SpiLoader.load(TolerantStrategy.class);
    }

    /**
     * 默认容错策略
     */
    private static final TolerantStrategy DEFAULT_RETRY_STRATEGY = new FailFastTolerantStrategy();

    /**
     * 获取实例
     *
     * @param key
     * @return
     */
    public static TolerantStrategy getInstance(String key) {
        return SpiLoader.getInstance(TolerantStrategy.class, key);
    }

}
