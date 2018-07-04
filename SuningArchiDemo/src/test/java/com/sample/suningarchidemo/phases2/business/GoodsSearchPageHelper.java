package com.sample.suningarchidemo.phases2.business;

import com.sample.suningarchidemo.common.Printer;

/**
 * 负责对网络请求前的数据进行处理
 */
public class GoodsSearchPageHelper {

    public void searchGoods(String key, OnDataCallbackListener listener) {
        Printer.print("本地添加搜索历史记录持久化数据", true);

    }

    public interface OnDataCallbackListener {
        void onSucc(String data);

        void onFail();
    }
}
