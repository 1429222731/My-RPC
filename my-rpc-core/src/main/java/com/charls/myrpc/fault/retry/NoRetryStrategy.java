package com.charls.myrpc.fault.retry;

import com.charls.myrpc.model.RpcResponse;

import java.util.concurrent.Callable;

/**
 * @Author: charls
 * @Description: 不重试 - 重试策略
 * @Date: 2025/02/13/ 12:24
 * @Version: 1.0
 */
public class NoRetryStrategy implements RetryStrategy{

    /**
     * 重试
     *
     * @param callable
     * @return
     * @throws Exception
     */
    public RpcResponse doRetry(Callable<RpcResponse> callable) throws Exception {
        return callable.call();
    }

}
