package com.netty.base.netty.tcp.protocoltcp;

/**
 * @Author Mr.Yan
 * @Date 2020 / 08 /05 17:25
 * 协议包
 **/
public class MessageProtocol {
    private int len;
    private byte[] content;

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
