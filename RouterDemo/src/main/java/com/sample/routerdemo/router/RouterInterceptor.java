package com.sample.routerdemo.router;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

@Interceptor(priority = 7)
public class RouterInterceptor implements IInterceptor {
    private Context context;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if (postcard.getPath().equals(RouterManager.PAGE_FIRST)) {
            callback.onInterrupt(new RuntimeException("其它的都行，就是不让你跳转到第一个页面"));
        } else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {
        context = context.getApplicationContext();
    }
}
