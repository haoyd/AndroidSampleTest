package com.sample.gofdemo.抽象工厂模式;

/**
 * Created by haoyundong on 2016/11/5.
 */

public class AbstractFacSample1 {

    public void client() {
        User user = new User("uu");
        Department department = new Department("dd");

        IFactory factory = new AccessFactory();

        IUser iUser = factory.createUser();

        iUser.insert(user);

        iUser.getUser();
    }


    interface IFactory {
        IUser createUser();
        IDpartment createDepartment();
    }

    interface IUser {
        void insert(User user);

        User getUser();
    }

    interface IDpartment {
        void insert(Department department);

        Department getDepartment();
    }


    class SqlservierFactory implements IFactory {
        @Override
        public IUser createUser() {
            return new SqlserverUser();
        }

        @Override
        public IDpartment createDepartment() {
            return new SqlserverDepartment();
        }
    }

    class AccessFactory implements IFactory{

        @Override
        public IUser createUser() {
            return new AccessUser();
        }

        @Override
        public IDpartment createDepartment() {
            return new AccessDepartment();
        }
    }


    class SqlserverDepartment implements IDpartment {
        @Override
        public void insert(Department department) {
            System.out.println("在Sqlserver中给Department插入了一条记录");
        }

        @Override
        public Department getDepartment() {
            System.out.println("在SqlServer中根据ID得到了一条记录");
            return null;
        }
    }

    class AccessDepartment implements IDpartment {
        @Override
        public void insert(Department department) {
            System.out.println("在access中给Department插入了一条记录");
        }

        @Override
        public Department getDepartment() {
            System.out.println("在access中根据ID得到了一条记录");
            return null;
        }
    }

    class AccessUser implements IUser {
        @Override
        public void insert(User user) {
            System.out.println("在access中给user插入了一条记录");
        }

        @Override
        public User getUser() {
            return null;
        }
    }

    class SqlserverUser implements IUser {
        @Override
        public void insert(User user) {
            System.out.println("在Sqlserver中给Sqlserver插入了一条记录");
        }

        @Override
        public User getUser() {
            return null;
        }
    }





    class User {
        private String name;

        public User(String name) {
            this.name = name;
        }
    }

    class Department {
        private String name;
        public Department(String name) {
            this.name = name;
        }
    }










}
