package com.sample.suningarchidemo;

import com.sample.suningarchidemo.phases1.business.LoginPage;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        phases1();

    }


    private void phases1() {
        new LoginPage();
    }

}