package com.charls.examplespringbootprovider;

import com.charls.example.common.model.User;
import com.charls.example.common.service.UserService;
import com.charls.myrpc.springboot.starter.annotation.RpcService;
import org.springframework.stereotype.Service;

/**
 * @Author: charls
 * @Description: 用户服务实现类
 * @Date: 2025/02/13/ 15:58
 * @Version: 1.0
 */
@Service
@RpcService
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
