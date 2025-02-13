package com.charls.myrpc.fault.retry;

import com.charls.myrpc.model.RpcResponse;

import java.util.concurrent.Callable;

/**
 * @Author: charls
 * @Description: 重试策略
 * @Date: 2025/02/13/ 12:22
 * @Version: 1.0
 */
public interface RetryStrategy {

    /**
     * 重试
     *
     * @param callable
     * @return
     * @throws Exception
     */
    RpcResponse doRetry(Callable<RpcResponse> callable) throws Exception;

}
