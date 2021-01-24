package com.example.mydemo.message;

/**
 * @author jianxiong.deng
 * @date 2021/1/14
 * @des
 */
class KMessageLooper {
    public KMessagQueue mKMessagQueue;
    public static ThreadLocal<KMessageLooper> sThreadLocal = new ThreadLocal<>();

    private KMessageLooper() {
        mKMessagQueue = new KMessagQueue();
    }

    public static void prepare() {
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("当前线程只能有一个Looper");
        }
        sThreadLocal.set(new KMessageLooper());
    }

    // 获取当前线程Looper
    public static KMessageLooper myLooper() {
        return sThreadLocal.get();
    }

    // loop queue
    public static void loop() {
        final KMessageLooper looper = myLooper();
        if (looper == null) {
            throw new RuntimeException("no looper init and loop.prepare not int this thread");
        }
        for (; ; ) {
            KMessage message = null;
            try {

                message = looper.mKMessagQueue.next();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (null != message) {
                message.target.dispatchMessage(message);
            }
        }
    }
}
