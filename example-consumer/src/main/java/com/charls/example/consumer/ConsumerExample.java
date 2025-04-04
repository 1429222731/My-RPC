package com.charls.example.consumer;

import com.charls.example.common.model.User;
import com.charls.example.common.service.UserService;
import com.charls.myrpc.bootstrap.ConsumerBootstrap;
import com.charls.myrpc.config.RpcConfig;
import com.charls.myrpc.proxy.ServiceProxyFactory;
import com.charls.myrpc.utils.ConfigUtils;

/**
 * @Author: charls
 * @Description: 服务消费者示例
 * @Date: 2025/02/11/ 21:33
 * @Version: 1.0
 */
public class ConsumerExample {

    public static void main(String[] args) {
        // 服务提供者初始化
        ConsumerBootstrap.init();

        // 获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("charls");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }

    /*public static void main(String[] args) {
//        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
//        System.out.println(rpc);

        for (int i = 0; i < 3; i++) {
            // 获取代理
            UserService userService = ServiceProxyFactory.getProxy(UserService.class);
            User user = new User();
            user.setName("charls");
            // 调用
            User newUser = userService.getUser(user);
            if (newUser != null) {
                System.out.println(newUser.getName());
            } else {
                System.out.println("user == null");
            }

            long number = userService.getNumber();
            System.out.println(number);
        }
    }*/
}
