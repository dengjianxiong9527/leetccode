package com.example.mydemo.theard;

/**
 * @author jianxiong.deng
 * @date 2021/1/12
 * @des
 */
class ThreadYieldDemo implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        ThreadYieldDemo threadYieldDemo = new ThreadYieldDemo();

        Thread t1 = new Thread(threadYieldDemo, "FirstThread");
        Thread t2 = new Thread(threadYieldDemo, "SecondThread");

        t1.start();
        t2.start();
    }
}
