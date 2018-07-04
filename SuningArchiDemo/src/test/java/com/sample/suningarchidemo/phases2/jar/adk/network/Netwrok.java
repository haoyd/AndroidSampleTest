package com.sample.suningarchidemo.phases2.jar.adk.network;

import com.sample.suningarchidemo.common.OnNetCallbackListener;
import com.sample.suningarchidemo.common.Printer;

public class Netwrok {

    public static void requestNet(OnNetCallbackListener listener) {
        Printer.print("请求网络接口", true);
        listener.onSuccess("返回请求数据");
    }
}
