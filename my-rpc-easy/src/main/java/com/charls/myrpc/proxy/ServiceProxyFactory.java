package com.charls.myrpc.proxy;

import java.lang.reflect.Proxy;

/**
 * @Author: charls
 * @Description: 服务代理工厂（用于创建代理对象）
 * @Date: 2025/02/11/ 16:18
 * @Version: 1.0
 */
public class ServiceProxyFactory {

    /**
     * 根据服务类创建代理对象
     * @param serviceClass
     * @return
     * @param <T>
     */
    public static <T> T getProxy(Class<T> serviceClass) {
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new ServiceProxy());
    }
}
