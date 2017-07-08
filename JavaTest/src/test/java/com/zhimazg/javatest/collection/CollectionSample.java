package com.zhimazg.javatest.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by haoyundong on 2016/12/14.
 */

public class CollectionSample {

    public void client() {
//        test1();
//        test2();
        test3();
    }


    private void test1() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        map.put("4", "four");

        Set set = map.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry entry= (Map.Entry) iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println(key + "  " + value);
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }

        for (String value : map.values()) {
            System.out.println(value);
        }

        for (String key : map.keySet()) {
            System.out.print(key + ">>>");
            System.out.println(map.get(key));
        }


    }

    private void test2() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "one");
        map.put("1", "one");
        Iterator iterator = map.entrySet().iterator();

        System.out.println("HashMap:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        Map<String, String> map1 = new LinkedHashMap<String, String>();
        map1.put("1", "one");
        map1.put("1", "one");
        Iterator iterator1 = map1.entrySet().iterator();

        System.out.println("LinkedHashMap:");
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }


    }

    private void test3() {
        Set<String> set = new HashSet<String>();
        set.add("a");
        set.add("a");
        Iterator iterator = set.iterator();
        System.out.println("HashSet:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Set<String> set1 = new LinkedHashSet<String>();
        set1.add("a");
        set1.add("a");
        Iterator iterator1 = set1.iterator();
        System.out.println("LinkedHashSet:");
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        Set<String> set2 = new TreeSet<String>();
        set2.add("a");
        set2.add("a");
        Iterator iterator2 = set2.iterator();
        System.out.println("TreeSet:");
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }


        List list = new ArrayList();
    }

    /**
     * 在这儿定义了一些容器必须复写的方法
     */
    private void test4() {

        class SetType{

            @Override
            public boolean equals(Object o) {
                return super.equals(o);
            }
        }

        class HashType{

            @Override
            public boolean equals(Object o) {
                return super.equals(o);
            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }
        }

        class TreeType implements Comparable{

            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }

    }



}
