package com.zhimazg.javatest.注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by haoyundong on 2016/12/17.
 */

public class AnnotationSample {

    @Hello
    public void client() {

    }


    @Hello2(id = 2, description = "How do you do!")
    private void testHello2() {

    }






    @Target(ElementType.METHOD)//用来定义它们作用于哪些地方
    public @interface Hello{

    }



    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Hello2{
        public int id();

        public String description() default "no description";
    }
}
