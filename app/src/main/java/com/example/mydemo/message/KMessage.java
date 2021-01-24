package com.example.mydemo.message;

import android.os.Message;

import java.io.Serializable;

/**
 * @author jianxiong.deng
 * @date 2021/1/14
 * @des
 */
class KMessage {
    // 消息类别
    private int what;
    // 消息内容
    private Object mObject;

    public KHandler target;

    public int getWhat() {
        return what;
    }

    public void setWhat(int what) {
        this.what = what;
    }

    public Object getObject() {
        return mObject;
    }

    public void setObject(Object object) {
        mObject = object;
    }
}

