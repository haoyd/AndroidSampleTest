package com.zhimazg.javatest;

import com.zhimazg.javatest.collection.CollectionSample;
import com.zhimazg.javatest.exception.SimpleException;
import com.zhimazg.javatest.reconstruct.Customer;
import com.zhimazg.javatest.reflect.ReflectSample;
import com.zhimazg.javatest.type.TypeInfo;
import com.zhimazg.javatest.初始化与清理.EnumDemo;
import com.zhimazg.javatest.初始化与清理.InitTest;
import com.zhimazg.javatest.持有对象.ObjectHolder;
import com.zhimazg.javatest.正则表达式.RegularSample;
import com.zhimazg.javatest.注解.AnnotationSample;
import com.zhimazg.javatest.类型信息.Animal;
import com.zhimazg.javatest.类型信息.Dog;
import com.zhimazg.javatest.面向对象.TestObject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest  {

    @Test
    public void addition_isCorrect() throws Exception {
//        testClass();
//        testObject();
//        testInit();

//        enumTest();
//        holdObject();

//        regulation();

//        testType();

//        reflectTest();

//        collectionTest();

//        annotationTest();

//        ExecutorService pool = Executors.newFixedThreadPool(2);

//        testStringReplace();

        testReconstruct();

    }

    private void testReconstruct() {
        Customer constructTest = new Customer();
        constructTest.client();
    }

    private void testStringReplace() {
        Duration.setStart();

        for(int i = 0; i < 100; i++) {
            String releaseUrl = "http://api.shop.zhimazg.com";
            String debugUrl = "http://test.shopapi.zhimadj.com";
            String url = "http://api.shop.zhimazg.com/user/me";
            url.replace(releaseUrl, debugUrl);
        }

        Duration.setEnd();

        System.out.println(Duration.getDuration());

    }



    private void print(Object msg) {
        System.out.println(msg);
    }



    private void throwException() throws SimpleException{
        throw new SimpleException("抛出异常信息示例");
    }


    /**
     * 泛型示例
     * @param <T>
     */
    class MyAdapter<T>{
        List<T> list = new ArrayList<T>();

        public MyAdapter(List<T> list) {
            this.list = list;
        }

        public void show() {
            System.out.println(list);
        }
    }


    private void testClass() {
        Animal dog = new Dog();

        Class c = null;

        try {
            c = Class.forName("Dog");
        } catch (ClassNotFoundException e) {
            print("can't find Dog");
        }

        print(c);
    }

    private void testObject() {
        new TestObject().print();
    }


    private void testInit() {
        InitTest initTest = new InitTest();
//        initTest.print();
        initTest.b();

        initTest = null;

        System.gc();


    }

    private void enumTest() {
        EnumDemo enumDemo = new EnumDemo();
        enumDemo.print();
    }

    private void holdObject() {
        ObjectHolder holder = new ObjectHolder();
        holder.client();
    }

    private void regulation() {
        new RegularSample().client();
    }

    private void testType() {
        new TypeInfo().client();
    }

    private void reflectTest() {
        ReflectSample reflectSample = new ReflectSample();
        reflectSample.client();
    }

    private void collectionTest() {
        new CollectionSample().client();
    }

    private void annotationTest() {
        new AnnotationSample().client();
    }

    public static class Duration
    {
        public static long start;
        public static long end;

        public static void reset()
        {
            start = 0;
            end = 0;
        }

        public static void setStart()
        {
            start = System.currentTimeMillis();
        }

        public static void setEnd()
        {
            end = System.currentTimeMillis();
        }

        public static long getDuration()
        {
            return (end - start);
        }
    }

}