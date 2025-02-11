package com.charls.myrpc.server;

/**
 * @Author: charls
 * @Description: HTTP 服务器接口
 * @Date: 2025/02/11/ 15:06
 * @Version: 1.0
 */
public interface HttpServer {

    /**
     * 启动服务器
     * @param port
     */
    void doStart(int port);
}
