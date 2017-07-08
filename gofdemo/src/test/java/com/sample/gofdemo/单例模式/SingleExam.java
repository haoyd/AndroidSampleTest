package com.sample.gofdemo.单例模式;

/**
 * Created by haoyundong on 2017/1/1.
 */

public class SingleExam {

    public void client() {
        Single1 single1 = Single1.getInstance();
        Single2 single2 = Single2.getInstance();
        Single3 single3 = Single3.getInstance();
        Single4 single4 = Single4.getInstance();
        Single5 single5 = Single5.getInstance();
        Single6 single6 = Single6.getInstance();
    }

    /**
     * 饿汉式
     * 说明：如果这个类用的比较频繁，又不需要考虑太多节省资源的问题，就可以直接用饿汉式
     */
    static class Single1 {
        private static Single1 single1 = new Single1();

        private Single1(){}

        public static Single1 getInstance() {
            return single1;
        }
    }

    /**
     * 懒汉式
     * 说明：这个类可能用得不是特别频繁，有可能会用也有可能不会用到，那么没必要在程序一启动的时候就将其载入内存，这个时候可以考虑用懒汉式。
     */
    static class Single2 {
        private static Single2 single2;

        private Single2(){}

        public static Single2 getInstance() {
            if (single2 == null) {
                single2 = new Single2();
            }
            return single2;
        }
    }

    /**
     * 懒汉式解决线程同步的问题1
     * 说明：如果同时存在多个线程会访问这个类，那么这个时候就要考虑线程同步的问题，否则可能建立多个实例。
     */
    static class Single3 {
        private static Single3 single3;

        private Single3(){}

        public synchronized static Single3 getInstance() {
            if (single3 == null) {
                single3 = new Single3();
            }
            return single3;
        }
    }

    /**
     * 懒汉式解决线程同步的问题2
     * 说明：像第一种方式是可以解决同步问题，但是方式略微有些暴力，一旦有一个线程在访问它，其它的根本进不来，这个时候可以选择为访问者开放一些权限，让其可以进入方法
     */
    static class Single4 {
        private static Single4 single4;

        private Single4(){}

        public static Single4 getInstance() {
            synchronized (Single4.class) {
                if (single4 == null) {
                    single4 = new Single4();
                }
            }
            return single4;
        }
    }

    /**
     * 懒汉式解决线程同步的问题3
     * 说明：Single4和Single3好像差不太多，貌似都没有节省太多资源，虽然Single4是进入到了方法内，
     * 但是还是一样的等待，我们有没有一种方法可以判断对像如果已经创建就不要再等待了，如果没创建就等待，
     * 看以下这种方法，它很好的解决了这个问题，如果已经创建了，就直接返回对象，不用做任何的加锁操作。
     */
    static class Single5 {
        private static Single5 single5;

        private Single5(){}

        public static Single5 getInstance() {
            if (single5 == null) {
                synchronized (Single5.class) {
                    single5 = new Single5();
                }
            }
            return single5;
        }
    }

    /**
     * 懒汉式解决线程同步的问题3
     * 说明：上面的方法似乎已经完美了，但还是会有一个缺陷，想想看：如果两个线程的访问者都已经通过了锁，
     * 都进入到了synchronized内部，那么这个时候会又会创建多个对象，这个时候应该在里面再多一层的判断，
     * 好的，这样完美解决了线程的同步的问题，而又不失效率。
     */
    static class Single6 {
        private static Single6 single6;

        private Single6(){}

        public static Single6 getInstance() {
            if (single6 == null) {
                synchronized (Single6.class) {
                    if (single6 == null) {
                        single6 = new Single6();
                    }
                }
            }
            return single6;
        }
    }

}
