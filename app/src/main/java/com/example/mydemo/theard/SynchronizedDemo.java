package com.example.mydemo.theard;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jianxiong.deng
 * @date 2020/12/9
 * @des
 */

/// synchronized 修饰方法 内置锁保护怎个方法
/// synchronized 静态代码块
/// 原子性和可见性，
class SynchronizedDemo {
    private  int count =0;

    public synchronized void add(int money){
        count += money;
        System.out.println(System.currentTimeMillis() + "存进：" + money);
    }

    public synchronized void sub(int money){
        if(count - money <= 0){
            System.out.println("余额不足");
            return;
        }
        count -= money;
        System.out.println(+System.currentTimeMillis() + "取出：" + money);
    }

    public void add1(int money){
        synchronized (this){
            count += money;
            System.out.println(System.currentTimeMillis() + "存进：" + money);
        }

    }

    public synchronized void sub1(int money){
        synchronized (this){
            if(count - money <= 0){
                System.out.println("余额不足");
                return;
            }
            count -= money;
            System.out.println(+System.currentTimeMillis() + "取出：" + money);
        }

    }
}

/// volatile 轻量级同步的方式，不会提供原子操作，可见性，不会加锁
class VolatileDemo {
    private  volatile int count =0;

    public  void add(int money){
        count += money;
        System.out.println(System.currentTimeMillis() + "存进：" + money);
    }

    public  void sub(int money){
        if(count - money <= 0){
            System.out.println("余额不足");
            return;
        }
        count -= money;
        System.out.println(+System.currentTimeMillis() + "取出：" + money);
    }
}
/// 要手动释放，公平锁 优先给等待时间最长的线程
class LockDemo{
    private int count = 0;
    private Lock mLock = new ReentrantLock();
    public  void add(int money){
        mLock.lock();
        try {
            count += money;
            System.out.println(System.currentTimeMillis() + "存进：" + money);
        }catch (Exception exception){

        }finally {
            mLock.unlock();
        }

    }

}

/// ThreadLocal 用于保存线程的共享变量，内部是TheradLocalMap 键对值的形式 key 为当前threadLocal的弱引用
class ThreadLocalDemo{
    private ThreadLocal<Integer> count = new ThreadLocal<Integer>();
    public  void add(int money){
        count.set(count.get() + money);
        System.out.println(System.currentTimeMillis() + "存进：" + money);
    }

    public  void sub(int money){
        if(count.get() - money <= 0){
            System.out.println("余额不足");
            return;
        }
        count.set(count.get() - money);
        System.out.println(+System.currentTimeMillis() + "取出：" + money);
    }

}

