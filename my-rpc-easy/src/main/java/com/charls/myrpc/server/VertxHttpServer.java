package com.charls.myrpc.server;

import io.vertx.core.Vertx;

/**
 * @Author: charls
 * @Description: Vertx HTTP 服务器
 * @Date: 2025/02/11/ 15:08
 * @Version: 1.0
 */
public class VertxHttpServer implements HttpServer{

    /**
     * 启动服务器
     * @param port
     */
    @Override
    public void doStart(int port) {
        // 创建Vert.x实例
        Vertx vertx = Vertx.vertx();

        // 创建HTTP服务器
        io.vertx.core.http.HttpServer server = vertx.createHttpServer();

        // 监听端口并处理请求
        server.requestHandler(new HttpServerHandler());

        server.listen(port, result -> {
            if (result.succeeded()) {
                System.out.println("Server is now listining on port " + port);
            } else {
                System.out.println("Failed to start server: " + result.cause());
            }
        });
    }
}
