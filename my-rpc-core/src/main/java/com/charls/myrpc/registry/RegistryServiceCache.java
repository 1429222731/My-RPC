package com.charls.myrpc.registry;

import com.charls.myrpc.model.ServiceMetaInfo;

import java.util.List;

/**
 * @Author: charls
 * @Description: 注册中心服务本地缓存
 * @Date: 2025/02/12/ 14:59
 * @Version: 1.0
 */
public class RegistryServiceCache {

    /**
     * 服务缓存
     */
    List<ServiceMetaInfo> serviceCache;

    /**
     * 写缓存
     *
     * @param newServiceCache
     * @return
     */
    void writeCache(List<ServiceMetaInfo> newServiceCache) {
        this.serviceCache = newServiceCache;
    }

    /**
     * 读缓存
     *
     * @return
     */
    List<ServiceMetaInfo> readCache() {
        return this.serviceCache;
    }

    /**
     * 清空缓存
     */
    void clearCache() {
        this.serviceCache = null;
    }

}
