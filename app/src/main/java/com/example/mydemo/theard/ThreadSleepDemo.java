package com.example.mydemo.theard;

/**
 * @author jianxiong.deng
 * @date 2021/1/12
 * @des 线程间的协作 sleep
 * sleep 暂停会一直持有锁，其他线程不能进入
 * wait 会释放出锁 并且依赖同步
 */
class ThreadSleepDemo {

    public synchronized void testSleep() {
        System.out.println("sleep Start-----");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sleep  End-------");
    }

    public synchronized void testWait() {
        System.out.println("wait Start-----");
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("wit  End-------");
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadSleepDemo threadDemo = new ThreadSleepDemo();

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadDemo.testSleep();
                }
            }).start();
        }

        Thread.sleep(10000);
        System.out.println("-----------分割线-------------");

        final ThreadSleepDemo threadDemo2 = new ThreadSleepDemo();

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadDemo2.testWait();
                }
            }).start();
        }
    }

}
