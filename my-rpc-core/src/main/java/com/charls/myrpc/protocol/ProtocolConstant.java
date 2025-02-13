package com.charls.myrpc.protocol;

/**
 * @Author: charls
 * @Description: 协议常量
 * @Date: 2025/02/12/ 15:45
 * @Version: 1.0
 */
public interface ProtocolConstant {

    /**
     * 消息头长度
     */
    int MESSAGE_HEADER_LENGTH = 17;

    /**
     * 协议魔数
     */
    byte PROTOCOL_MAGIC = 0x1;

    /**
     * 协议版本号
     */
    byte PROTOCOL_VERSION = 0x1;

}
