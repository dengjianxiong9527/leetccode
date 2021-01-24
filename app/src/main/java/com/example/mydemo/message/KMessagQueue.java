package com.example.mydemo.message;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author jianxiong.deng
 * @date 2021/1/14
 * @des
 */
class KMessagQueue {
    private BlockingQueue<KMessage> mQueue;
    private static final int MAX_COUNT = 50;

    public KMessagQueue() {
        mQueue = new ArrayBlockingQueue<>(MAX_COUNT);
    }

    // 入队
    public void enqueueMessage(KMessage msg){
        mQueue.add(msg);
    }

    // 出队
    public KMessage next() throws InterruptedException {
        KMessage message = null;
        message = mQueue.take();
        return message;
    }

}
