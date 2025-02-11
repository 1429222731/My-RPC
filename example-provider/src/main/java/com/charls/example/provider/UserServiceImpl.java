package com.charls.example.provider;

import com.charls.example.common.model.User;
import com.charls.example.common.service.UserService;

/**
 * @Author: charls
 * @Description: 用户服务实现类
 * @Date: 2025/02/11/ 14:55
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
