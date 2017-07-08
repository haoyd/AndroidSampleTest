package com.zhimazg.javatest.type;

/**
 * Created by haoyundong on 2016/12/12.
 */

public class TypeInfo {

    public void client() {
//       test1();
//        test2();
        test3();
    }

    private void test1() {
        Class c = null;
        try {
            c = Class.forName("com.zhimazg.javatest.type.Person");
        } catch (ClassNotFoundException e) {
            print("找不到对象");
        }
        printInfo(c);

        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }

        Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        printInfo(obj.getClass());
    }

    private void test2() {
        Animal dog = new Dog();
        dog.eat();

        System.out.println(dog.getClass().getSimpleName());

        if (dog instanceof Dog) {
            ((Dog)dog).call();
        }
    }

    private void test3() {
        Animal dog = new Dog();
        Animal cat = new Cat();

        System.out.println(dog.getClass().getSimpleName());
        System.out.println(cat.getClass().getSimpleName());
    }


    private void printInfo(Class c) {
        print("className:" + c.getName());
        print("isInterface:" + c.isInterface());
        print("simpleName:" + c.getSimpleName());
        print("canonicalName:" + c.getCanonicalName());
        print("");
    }


    interface InterfaceA{}
    interface InterfaceB{}
    interface InterfaceC{}
    interface InterfaceD{}


    public class FancyToy extends Toy implements InterfaceA, InterfaceB, InterfaceC {
        FancyToy() {
            super();
        }
    }

    private void print(String string) {
        System.out.println(string);
    }

}
