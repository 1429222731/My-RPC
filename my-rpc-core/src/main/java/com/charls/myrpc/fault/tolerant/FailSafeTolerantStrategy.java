package com.charls.myrpc.fault.tolerant;

import com.charls.myrpc.model.RpcResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @Author: charls
 * @Description: 静默处理异常 - 容错策略
 * @Date: 2025/02/13/ 12:58
 * @Version: 1.0
 */
@Slf4j
public class FailSafeTolerantStrategy implements  TolerantStrategy{

    @Override
    public RpcResponse doTolerant(Map<String, Object> context, Exception e) {
        log.info("静默处理异常", e);
        return new RpcResponse();
    }

}
