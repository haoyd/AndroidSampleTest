package com.sample.suningarchidemo.phases2.business;

import com.sample.suningarchidemo.common.Printer;

public class GoodsSearchPage {

    private GoodsSearchPageHelper mHelper;

    /**
     * 整个请求采用责任链，保证各个环节清晰明了
     *
     * 以下请求大致需要分为以下几个环节：
     * 1. 页面负责用户输入输入
     * 2. 负责用户数据保存处理
     * 3. 负责网络给网络请求添加公共参数
     * 4. 负责网络请求
     * 5. 判断code msg, 0：回调成功  其它：回调失败
     * 6. 返回的数据添加客显临时数据，方便客户端显示
     *
     */
    public GoodsSearchPage() {
        Printer.print("初始化商品搜索页面", true);

        mHelper = new GoodsSearchPageHelper();

        searchGoods();

        Printer.print("网络请求添加公共参数", true);
        Printer.print("请求网络接口", true);
        Printer.print("返回请求结果", true);
        Printer.print("判断code msg", true);
        Printer.print("对返回的数据Model添加额外客显数据", true);

    }

    private void searchGoods() {
        Printer.print("搜索商品：娃哈哈", true);
        mHelper.searchGoods("娃哈哈", new GoodsSearchPageHelper.OnDataCallbackListener() {
            @Override
            public void onSucc(String data) {
                Printer.print("客户端显示数据");
            }

            @Override
            public void onFail() {

            }
        });


    }


}
