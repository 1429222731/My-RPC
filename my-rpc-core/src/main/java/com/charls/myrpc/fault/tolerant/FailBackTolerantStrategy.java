package com.charls.myrpc.fault.tolerant;

import com.charls.myrpc.model.RpcResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @Author: charls
 * @Description: 降级到其他服务 - 容错策略
 * @Date: 2025/02/13/ 13:00
 * @Version: 1.0
 */
@Slf4j
public class FailBackTolerantStrategy implements TolerantStrategy {

    @Override
    public RpcResponse doTolerant(Map<String, Object> context, Exception e) {
        // todo 可自行扩展，获取降级的服务并调用
        return null;
    }

}
