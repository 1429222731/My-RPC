package com.charls.myrpc.fault.tolerant;

import com.charls.myrpc.model.RpcResponse;

import java.util.Map;

/**
 * @Author: charls
 * @Description: 快速失败 - 容错策略（立刻通知外层调用方）
 * @Date: 2025/02/13/ 12:57
 * @Version: 1.0
 */
public class FailFastTolerantStrategy implements TolerantStrategy{

    @Override
    public RpcResponse doTolerant(Map<String, Object> context, Exception e) {
        throw new RuntimeException("服务报错", e);
    }

}
