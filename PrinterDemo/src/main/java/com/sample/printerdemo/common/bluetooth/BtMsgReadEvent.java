package com.sample.printerdemo.common.bluetooth;

/**
 * Created by liuguirong on 8/1/17.
 * <p/>
 * read bytes from bluetooth
 */
public class BtMsgReadEvent {

    public int bytes;
    public byte[] buffer;
    public String message;

    public BtMsgReadEvent(int bytes, byte[] buffer) {
        this.buffer = buffer;
        this.bytes = bytes;
        this.message = new String(buffer, 0, bytes);
    }
}