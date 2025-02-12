package com.charls.myrpc.registry;

import com.charls.myrpc.spi.SpiLoader;

/**
 * @Author: charls
 * @Description: 注册中心工厂（用于获取注册中心对象）
 * @Date: 2025/02/12/ 13:49
 * @Version: 1.0
 */
public class RegistryFactory {

    static {
        SpiLoader.load(Registry.class);
    }

    /**
     * 默认注册中心
     */
    private static final Registry DEFAULT_REGISTRY = new EtcdRegistry();

    /**
     * 获取实例
     *
     * @param key
     * @return
     */
    public static Registry getInstance(String key) {
        return SpiLoader.getInstance(Registry.class, key);
    }
}
