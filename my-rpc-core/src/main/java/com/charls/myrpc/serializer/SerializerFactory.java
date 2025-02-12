package com.charls.myrpc.serializer;

import com.charls.myrpc.spi.SpiLoader;

/**
 * @Author: charls
 * @Description: 序列化器工厂（工厂模式，用于获取序列化器对象）
 * @Date: 2025/02/12/ 10:57
 * @Version: 1.0
 */
public class SerializerFactory {

    static {
        SpiLoader.load(Serializer.class);
    }

    /**
     * 默认序列化器
     */
    private static final Serializer DEFAULT_SERIALIZER = new JdkSerializer();

    /**
     * 获取实例
     *
     * @param key
     * @return
     */
    public static Serializer getInstance(String key) {
        return SpiLoader.getInstance(Serializer.class, key);
    }


}
