package com.sample.msgintercept;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by haoyundong on 16/8/26.
 */

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("SmsReceiver启动........");

        Bundle bundle = intent.getExtras();
        SmsMessage msg = null;

        if(bundle != null){
            Object[] smsObj = (Object[]) bundle.get("pdus");
            for (Object object : smsObj) {
                msg = SmsMessage.createFromPdu((byte[]) object);
                Date date = new Date(msg.getTimestampMillis());//时间
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String receiveTime = format.format(date);
                System.out.println("number:" + msg.getOriginatingAddress()
                        + "   body:" + msg.getDisplayMessageBody() + "  time:"
                        + msg.getTimestampMillis());

                //在这里写自己的逻辑
                if (msg.getOriginatingAddress().equals("10086")) {
                    //TODO
                    for(int i = 0;i < 100;i++){
                        System.out.println("10086来短信了");
                    }
                }

            }
        }

    }
}
