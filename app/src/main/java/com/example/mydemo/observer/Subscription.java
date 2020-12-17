package com.example.mydemo.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianxiong.deng
 * @date 2020/12/8
 * @des
 */
public class Subscription implements KObservable{
    private List<WeixinUser> mWeixinUsers = new ArrayList<>();

    @Override
    public void addWeiXinUser(WeixinUser weixinUser) {
        mWeixinUsers.add(weixinUser);
    }

    @Override
    public void RemoveWeiXinUer(WeixinUser weixinUser) {
        mWeixinUsers.remove(weixinUser);
    }

    @Override
    public void notify(String message) {
        for(WeixinUser weixinUser : mWeixinUsers){
            weixinUser.update(message);
        }
    }
}
