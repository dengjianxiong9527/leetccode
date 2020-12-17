package com.example.mydemo.object;

/**
 * @author jianxiong.deng
 * @date 2020/12/7
 * @des 依赖倒置原则：面向抽象或者接口编程
 */
class DepInversionPri {
    interface Hobby {
        void playGame();
    }

    class Boy implements Hobby {

        @Override
        public void playGame() {
            System.out.print("运动");
        }
    }

    class Girl implements Hobby {

        @Override
        public void playGame() {
            System.out.print("化妆");
        }
    }

    public static void main(String args[]){

    }
}
