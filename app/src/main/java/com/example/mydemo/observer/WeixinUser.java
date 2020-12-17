package com.example.mydemo.observer;

/**
 * @author jianxiong.deng
 * @date 2020/12/8
 * @des
 */
class WeixinUser implements KObserver {
    private String name;

    public WeixinUser(String name){
        this.name = name;
    }

    @Override
    public void update(String message) {

    }
}
