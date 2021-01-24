package com.example.mydemo.message;

/**
 * @author jianxiong.deng
 * @date 2021/1/16
 * @des
 */
class KHandler {
    final KMessageLooper mKMessageLooper;
    final KMessagQueue mKMessagQueue;

    public KHandler() {
        this.mKMessageLooper = KMessageLooper.myLooper();
        mKMessagQueue = mKMessageLooper.mKMessagQueue;
    }

    // 发送消息
    public void sendMessage(KMessage kMessage){
           enqueueMessage(kMessage);
    }

    // 插入消息
    public void enqueueMessage(KMessage message){
        message.target = this;
        mKMessagQueue.enqueueMessage(message);
    }

    // 分发消息
    public void dispatchMessage(KMessage message) {
        handleMessage(message);
    }
    public void handleMessage(KMessage message) {
    }
}
