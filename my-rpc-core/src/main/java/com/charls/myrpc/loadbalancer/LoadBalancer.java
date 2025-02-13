package com.charls.myrpc.loadbalancer;

import com.charls.myrpc.model.ServiceMetaInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author: charls
 * @Description: 负载均衡器（消费端使用）
 * @Date: 2025/02/13/ 11:12
 * @Version: 1.0
 */
public interface LoadBalancer {

    /**
     * 选择服务调用
     *
     * @param requestParams       请求参数
     * @param serviceMetaInfoList 可用服务列表
     * @return
     */
    ServiceMetaInfo select(Map<String, Object> requestParams, List<ServiceMetaInfo> serviceMetaInfoList);

}
