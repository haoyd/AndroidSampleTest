package com.sample.suningarchidemo.phases1.proxy.storage;

import com.sample.suningarchidemo.common.Printer;

public class LoginStorageServiceImpl implements LoginStorageService{

    @Override
    public void saveToken(String token) {
        Printer.print("token数据持久化", true);
    }
}
