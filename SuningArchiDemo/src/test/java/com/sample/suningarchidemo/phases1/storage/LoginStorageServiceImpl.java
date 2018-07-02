package com.sample.suningarchidemo.phases1.storage;

public class LoginStorageServiceImpl implements LoginStorageService{

    @Override
    public void saveToken(String token) {
        System.out.println("token数据持久化");
    }
}
