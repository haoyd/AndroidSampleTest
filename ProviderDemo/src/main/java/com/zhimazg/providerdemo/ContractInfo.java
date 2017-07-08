package com.zhimazg.providerdemo;

/**
 * Created by haoyundong on 2016/10/19.
 */

public class ContractInfo {

    private String name = "";
    private String phone = "";
    private String from = "";

    public ContractInfo(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
