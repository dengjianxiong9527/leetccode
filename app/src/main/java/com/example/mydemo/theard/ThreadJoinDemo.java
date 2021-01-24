package com.example.mydemo.theard;

/**
 * @author jianxiong.deng
 * @date 2021/1/12
 * @des
 * 没有使用join方法之间，线程是并发执行的，而使用join方法后，所有线程是顺序执行的
 */
class ThreadJoinDemo implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " start-----");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " end------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 5; i++){
          Thread thread = new Thread(new ThreadJoinDemo());
          thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Finished~~~");
    }
}
