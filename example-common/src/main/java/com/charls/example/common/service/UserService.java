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
}
