package com.charls.myrpc.fault.tolerant;

/**
 * @Author: charls
 * @Description: 容错策略键名常量
 * @Date: 2025/02/13/ 13:02
 * @Version: 1.0
 */
public interface TolerantStrategyKeys {

    /**
     * 故障恢复
     */
    String FAIL_BACK = "failBack";

    /**
     * 快速失败
     */
    String FAIL_FAST = "failFast";

    /**
     * 故障转移
     */
    String FAIL_OVER = "failOver";

    /**
     * 静默处理
     */
    String FAIL_SAFE = "failSafe";

}
