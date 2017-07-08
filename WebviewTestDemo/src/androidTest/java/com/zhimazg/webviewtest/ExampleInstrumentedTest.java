package com.zhimazg.webviewtest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.zhimadj.utils.Jackson;
import com.zhimadj.utils.LogUtils;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.zhimazg.webviewtest", appContext.getPackageName());

        Map<String, String> map = new HashMap<String, String>();
        map.put("msg", "ok");

        String json = Jackson.toJson(map);
        System.out.println(json);




        try {
            JSONObject jsonObject = new JSONObject(json);
            String node = "";

            boolean a = jsonObject.has("msg");

            node = jsonObject.optString("msg");
            LogUtils.d(node);
            System.out.println(node);
        } catch (Exception e) {
            System.out.println("解析错误");
            e.printStackTrace();
        }
    }
}
