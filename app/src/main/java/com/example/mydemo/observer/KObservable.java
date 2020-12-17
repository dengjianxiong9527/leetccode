package com.example.mydemo.observer;

/**
 * @author jianxiong.deng
 * @date 2020/12/8
 * @des
 */
public interface KObservable {
    public void addWeiXinUser(WeixinUser weixinUser);
    public void RemoveWeiXinUer(WeixinUser weixinUser);
    public void notify(String message);
}
