package com.sample.mylibs;

import com.sample.mylibs.utils.Printer;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        Printer.print("hello world", true);
        Printer.print("hello world", true);
        Printer.print("hello world", false);
    }
}