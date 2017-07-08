package com.zhimazg.javatest.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by haoyundong on 2016/12/13.
 */

public class ReflectSample {

    public void client() {
        Class c = null;
        try {
            c = Class.forName("com.zhimazg.javatest.reflect.Person");

//            Person person = (Person) c.newInstance();
//            person.eat();
//            person.play();

            Constructor[] constructors = c.getConstructors();

            for (Constructor constructor : constructors) {
                System.out.println("构造方法：" + constructor.getName());
            }

            Method[] methods = c.getMethods();
            for (Method method : methods) {
                System.out.println(method.getDeclaringClass());
                System.out.println(method.getName());

                if ("eat".equals(method.getName())) {
                    String[] s = new String[1];
                    s[0] = "apple";

//                    method.invoke(new Person("Eric"), s);

                }

            }




        } catch (ClassNotFoundException e) {
            System.out.println("找不到对象");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {
        Class ownerClass = owner.getClass();

        Class[] argsClass = new Class[args.length];

        for(int i = 0; i < args.length; i++) {
            argsClass[i] = args.getClass();
        }

        Method method = ownerClass.getMethod(methodName, argsClass);

        return method.invoke(owner, args);
    }
}
