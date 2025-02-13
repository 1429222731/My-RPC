package com.charls.examplespringbootconsumer;

import com.charls.example.common.model.User;
import com.charls.example.common.service.UserService;
import com.charls.myrpc.springboot.starter.annotation.RpcReference;
import org.springframework.stereotype.Service;

/**
 * @Author: charls
 * @Description: 示例服务实现类
 * @Date: 2025/02/13/ 16:00
 * @Version: 1.0
 */
@Service
public class ExampleServiceImpl {

    @RpcReference
    private UserService userService;

    public void test() {
        User user = new User();
        user.setName("charls");
        User resultUser = userService.getUser(user);
        System.out.println(resultUser.getName());
    }
}
