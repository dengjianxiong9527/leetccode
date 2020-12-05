package com.example.mydemo.theard;

/**
 * @author jianxiong.deng
 * @date 2020/11/30
 * @des
 * 死锁: 1 线程deadLock1 锁定01 对象之后睡眠500，睡眠之后需要锁定02
 *       2 线程deadLock2 锁定o2 对象之后睡眠500，睡眠之后需要锁定o1
 *       3 相互等待 都需要得到对方的锁定资源才能继续执行
 */
class DeadLock implements Runnable{
    public int flag = 1;
    private static Object o1 = new Object(), o2 = new Object();
    @Override
    public void run() {
        System.out.println("flag=" + flag);
        if(flag == 1){
            synchronized (o1){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("flag=" + flag);
                }
            }
        }
        if(flag == 0){
           synchronized (o2){
               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               synchronized (o1){
                   System.out.println("0");
               }
           }
        }

    }

    public static void main(String[] args){
        DeadLock deadLock1 = new DeadLock();
        DeadLock deadLock2 = new DeadLock();
        deadLock1.flag = 1;
        deadLock2.flag = 2;
        new Thread(deadLock1).start();
        new Thread(deadLock2).start();
    }
}
