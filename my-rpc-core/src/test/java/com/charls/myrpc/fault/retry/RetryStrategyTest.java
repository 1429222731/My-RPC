package com.charls.myrpc.fault.retry;

import com.charls.myrpc.model.RpcResponse;
import org.junit.Test;

/**
 * @Author: charls
 * @Description: 重试策略测试
 * @Date: 2025/02/13/ 12:25
 * @Version: 1.0
 */
public class RetryStrategyTest {

    // 不重试
//    RetryStrategy retryStrategy = new NoRetryStrategy();

    // 固定间隔重试
    RetryStrategy retryStrategy = new FixedIntervalRetryStrategy();

    @Test
    public void doRetry() {
        try {
            RpcResponse rpcResponse = retryStrategy.doRetry(() -> {
                System.out.println("测试重试");
                throw new RuntimeException("模拟重试失败");
            });
            System.out.println(rpcResponse);
        } catch (Exception e) {
            System.out.println("重试多次失败");
            e.printStackTrace();
        }
    }
}