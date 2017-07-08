package com.zhimazg.eventbus;

/**
 * Created by haoyundong on 2016/10/31.
 */

public class MessageEvent {

    private String msg;

    public MessageEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
