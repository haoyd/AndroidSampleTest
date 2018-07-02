package com.sample.suningarchidemo.phases1.network;

public interface LoginNetService {

    void getAuthcode(String mobile, int type, OnNetCallbackListener listener);

    void regist(String mobile, String code, OnNetCallbackListener listener);

    void login(String mobile, String code, OnNetCallbackListener listener);



}
