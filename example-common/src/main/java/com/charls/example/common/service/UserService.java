package com.charls.example.common.service;

import com.charls.example.common.model.User;

/**
 * @Author: charls
 * @Description:用户服务
 * @Date: 2025/02/11/ 14:51
 * @Version: 1.0
 */
public interface UserService {

    /**
     * 获取用户
     * @param user
     * @return
     */
    User getUser(User user);

    /**
     * 用于测试 mock 接口返回值
     *
     * @return
     */
    default short getNumber() {
        return 1;
    }

}
