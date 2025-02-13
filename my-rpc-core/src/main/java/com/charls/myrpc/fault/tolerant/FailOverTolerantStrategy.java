package com.charls.myrpc.fault.tolerant;

import com.charls.myrpc.model.RpcResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @Author: charls
 * @Description: 转移到其他服务节点 - 容错策略
 * @Date: 2025/02/13/ 13:00
 * @Version: 1.0
 */
@Slf4j
public class FailOverTolerantStrategy implements TolerantStrategy {

    @Override
    public RpcResponse doTolerant(Map<String, Object> context, Exception e) {
        // todo 可自行扩展，获取其他服务节点并调用
        return null;
    }

}
