package com.charls.example.consumer;

import com.charls.example.common.model.User;
import com.charls.example.common.service.UserService;
import com.charls.myrpc.proxy.ServiceProxyFactory;

/**
 * @Author: charls
 * @Description: 简易服务消费者示例
 * @Date: 2025/02/11/ 15:00
 * @Version: 1.0
 */
public class EasyConsumerExample {
    public static void main(String[] args) {
        // 静态代理
//        UserService userService = new UserServiceProxy();

        // 动态代理
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
}
