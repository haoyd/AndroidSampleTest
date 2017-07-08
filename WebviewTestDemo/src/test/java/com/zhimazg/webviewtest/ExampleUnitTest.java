package com.zhimazg.webviewtest;

import com.zhimadj.utils.Jackson;

import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

        Map<String, String> map = new HashMap<String, String>();
        map.put("msg", "ok");

        String json = Jackson.toJson(map);
        System.out.println(json);




        try {
            JSONObject jsonObject = new JSONObject();
            String node = "";

            boolean a = jsonObject.has("msg");

            node = jsonObject.optString("msg");
            System.out.println(node);
        } catch (Exception e) {
            System.out.println("解析错误");
            e.printStackTrace();
        }
    }

    class MsgBean{

        /**
         * msg : ok
         */

        public String msg;


    }
}