package com.sample.suningarchidemo.phases1.network;

public class LoginNetServiceImpl implements LoginNetService {

    @Override
    public void getAuthcode(String mobile, int type, OnNetCallbackListener listener) {
        System.out.println("请求登录或注册页面的验证码");

        listener.onSuccess("8888");
    }

    @Override
    public void regist(String mobile, String code, OnNetCallbackListener listener) {
        System.out.println("注册账户");
        listener.onSuccess("token");
    }

    @Override
    public void login(String mobile, String code, OnNetCallbackListener listener) {
        System.out.println("登录账户");
        listener.onSuccess("token");
    }
}
