package com.charls.myrpc.springboot.starter.annotation;

import com.charls.myrpc.springboot.starter.bootstrap.RpcConsumerBootstrap;
import com.charls.myrpc.springboot.starter.bootstrap.RpcInitBootstrap;
import com.charls.myrpc.springboot.starter.bootstrap.RpcProviderBootstrap;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: charls
 * @Description: 启用 RPC 注解
 * @Date: 2025/02/13/ 15:33
 * @Version: 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({RpcInitBootstrap.class, RpcProviderBootstrap.class, RpcConsumerBootstrap.class})
public @interface EnableRpc {

    /**
     * 需要启动server
     * @return
     */
    boolean needServer() default true;
}
