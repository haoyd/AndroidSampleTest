package com.sample.gofdemo.享元模式;

import java.util.Hashtable;

/**
 * Created by haoyundong on 2016/11/9.
 */

public class FlyweightSample1 {

    public void client() {
        User user = new User("孟晨");

        WebsiteFactory factory = new WebsiteFactory();
        Website neihan = factory.getWebsite("内涵网站");
        Website tech = factory.getWebsite("技术网站");

        neihan.use(user);
        tech.use(user);
    }

    class User {
        String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    abstract class Website {

        public abstract void use(User user);
    }

    class ConcreteWebsite extends Website {
        private String name;

        public ConcreteWebsite(String name) {
            this.name = name;
        }

        @Override
        public void use(User user) {
            System.out.println("网站分类：" + name + "   用户：" + user.name);
        }
    }

    class WebsiteFactory {
        private Hashtable websites = new Hashtable();

        public Website getWebsite(String key) {
            if (!websites.contains(key)) {
                websites.put(key, new ConcreteWebsite(key));
            }

            return (Website) websites.get(key);
        }

        public int getWebsiteCount() {
            return websites.size();
        }
    }



}
