package com.charls.myrpc.config;

import lombok.Data;

/**
 * @Author: charls
 * @Description:RPC 框架全局配置
 * @Date: 2025/02/11/ 21:18
 * @Version: 1.0
 */
@Data
public class RpcConfig {

    /**
     * 名称
     */
    private String name = "my-rpc";

    /**
     * 版本号
     */
    private String version = "1.0";

    /**
     * 服务器主机名
     */
    private String serverHost = "localhost";

    /**
     * 服务器端口号
     */
    private Integer serverPort = 8080;

}
