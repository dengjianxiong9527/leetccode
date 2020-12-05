package com.example.mydemo.ramdemo;

import android.content.Context;

/**
 * @author jianxiong.deng
 * @date 2020/12/5
 * @des 单例模式持有Context 引用，Context 是Activity的时候， 当Activityfinish的时候 Activity 也不会被回收，这样容易造成内存泄露
 * 所以将context = context.getApplicationContext();
 * 单例模式引用的对象的生命周期 = 应用生命周期
 */
class SingleInstanceTest {
    private static SingleInstanceTest sSingleInstanceTest;
    private Context mContext;

    private SingleInstanceTest(Context context) {
        this.mContext = context;
    }

    public static SingleInstanceTest newInstance(Context context) {
        if (sSingleInstanceTest != null) {
            sSingleInstanceTest = new SingleInstanceTest(context);
        }
        return sSingleInstanceTest;
    }
}
