package com.charls.example.common.model;

import java.io.Serializable;

/**
 * @Author: charls
 * @Description:用户
 * @Date: 2025/02/11/ 14:50
 * @Version: 1.0
 */
public class User implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
