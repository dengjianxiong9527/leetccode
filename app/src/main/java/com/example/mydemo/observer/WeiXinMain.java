package com.example.mydemo.observer;

/**
 * @author jianxiong.deng
 * @date 2020/12/8
 * @des
 */
public class WeiXinMain {
    public static void main(String[] args){
        Subscription subscription = new Subscription();

        subscription.addWeiXinUser(new WeixinUser("daxiong"));
        subscription.addWeiXinUser(new WeixinUser("zhixiong"));
        subscription.addWeiXinUser(new WeixinUser("lixiong"));

        subscription.notify("New article coming");
    }
}
