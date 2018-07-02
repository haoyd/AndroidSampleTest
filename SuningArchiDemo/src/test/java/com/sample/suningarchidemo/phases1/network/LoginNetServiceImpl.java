package com.sample.suningarchidemo.phases1.network;

import com.sample.suningarchidemo.common.Printer;

public class LoginNetServiceImpl implements LoginNetService {

    @Override
    public void getAuthcode(String mobile, int type, OnNetCallbackListener listener) {
        Printer.print("请求登录或注册页面的验证码", true);

        listener.onSuccess("8888");
    }

    @Override
    public void regist(String mobile, String code, OnNetCallbackListener listener) {
        Printer.print("注册账户", true);
        listener.onSuccess("token");
    }

    @Override
    public void login(String mobile, String code, OnNetCallbackListener listener) {
        Printer.print("登录账户", true);
        listener.onSuccess("token");
    }
}
