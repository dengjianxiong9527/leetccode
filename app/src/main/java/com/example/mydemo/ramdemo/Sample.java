package com.example.mydemo.ramdemo;

import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * @author jianxiong.deng
 * @date 2020/12/5
 * @des
 * 使用弱引用WeakReference 让Gc 回收相关的引用
 */
class Sample {
    private WeakReference<Context> mContextWeakReference;
    public Sample(Context context){
        this.mContextWeakReference = new WeakReference<>(context);
    }
    public Context getContext(){
        if(mContextWeakReference.get() != null){
            return  mContextWeakReference.get();
        }
        return  null;
    }
}
