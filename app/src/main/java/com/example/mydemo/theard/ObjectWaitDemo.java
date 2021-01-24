package com.example.mydemo.theard;

/**
 * @author jianxiong.deng
 * @date 2021/1/12
 * @des 线程间的协作 wait
 * wait 会释放出锁 并且依赖同步
 */
class ObjectWaitDemo {

    public synchronized void testWait() {
        System.out.println("Start-----");
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End-------");
    }

    public static void main(String[] args) {
        final ObjectWaitDemo threadDemo = new ObjectWaitDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadDemo.testWait();
            }
        }).start();
    }

}
