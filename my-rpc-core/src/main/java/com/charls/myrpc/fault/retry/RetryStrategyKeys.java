package com.charls.myrpc.fault.retry;

/**
 * @Author: charls
 * @Description: 重试策略键名常量
 * @Date: 2025/02/13/ 12:34
 * @Version: 1.0
 */
public interface RetryStrategyKeys {

    /**
     * 不重试
     */
    String NO = "no";

    /**
     * 固定时间间隔
     */
    String FIXED_INTERVAL = "fixedInterval";

}
