package com.example.mydemo.message;

import android.util.Log;

import java.util.UUID;

/**
 * @author jianxiong.deng
 * @date 2021/1/16
 * @des
 */
class HandlerDemo {
    private static final String TAG = "HandlerDemo";

    public static void main(String[] args){
        KMessageLooper.prepare();
        KHandler kHandler = new KHandler(){
            @Override
            public void handleMessage(KMessage message) {
                super.handleMessage(message);
                Log.e(TAG, "receive:" + message.toString());
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                KMessage kMessage = new KMessage();
                kMessage.setWhat(123);
                String msg = Thread.currentThread().getName()+ UUID.randomUUID().toString();
                kMessage.setObject(msg);
                kHandler.sendMessage(kMessage);
            }
        }).start();

        KMessageLooper.loop();
    }
}
