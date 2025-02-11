package com.charls.example.consumer;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.charls.example.common.model.User;
import com.charls.example.common.service.UserService;
import com.charls.myrpc.model.RpcRequest;
import com.charls.myrpc.model.RpcResponse;
import com.charls.myrpc.serializer.JdkSerializer;
import com.charls.myrpc.serializer.Serializer;

import java.io.IOException;

/**
 * @Author: charls
 * @Description: 用户服务静态代理
 * @Date: 2025/02/11/ 16:09
 * @Version: 1.0
 */
public class UserServiceProxy implements UserService {
    @Override
    public User getUser(User user) {
        // 指定序列化器
        final Serializer serializer = new JdkSerializer();

        // 构造请求
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(UserService.class.getName())
                .methodName("getUser")
                .parameterTypes(new Class[]{User.class})
                .args(new Object[]{user})
                .build();
        try {
            // 序列化（Java 对象 => 字节数组）
            byte[] bodyBytes = serializer.serialize(rpcRequest);

            // 发送请求
            try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8080")
                    .body(bodyBytes)
                    .execute()) {
                byte[] result = httpResponse.bodyBytes();
                // 反序列化（字节数组 => Java 对象）
                RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
                return (User) rpcResponse.getData();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
