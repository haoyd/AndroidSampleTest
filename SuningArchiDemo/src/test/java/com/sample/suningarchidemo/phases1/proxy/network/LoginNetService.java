package com.sample.suningarchidemo.phases1.proxy.network;

import com.sample.suningarchidemo.common.OnNetCallbackListener;

public interface LoginNetService {

    void getAuthcode(String mobile, int type, OnNetCallbackListener listener);

    void regist(String mobile, String code, OnNetCallbackListener listener);

    void login(String mobile, String code, OnNetCallbackListener listener);



}
