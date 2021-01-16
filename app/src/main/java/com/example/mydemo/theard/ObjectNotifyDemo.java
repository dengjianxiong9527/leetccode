package com.example.mydemo.theard;

/**
 * @author jianxiong.deng
 * @date 2021/1/12
 * @des 线程间的协作 notify
 * 
 */
class ThreadNotifyDemo {

    public synchronized void testWait() {
        System.out.println(Thread.currentThread().getName() + "Start-----");
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "End-------");
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadNotifyDemo threadDemo = new ThreadNotifyDemo();

        for(int i = 0 ; i < 5; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadDemo.testWait();
                }
            }).start();
        }

        synchronized (threadDemo){
            threadDemo.notify();
        }

        Thread.sleep(3000);
        System.out.println("-----------分割线-------------");

        synchronized (threadDemo){
            threadDemo.notifyAll();
        }

    }

}
