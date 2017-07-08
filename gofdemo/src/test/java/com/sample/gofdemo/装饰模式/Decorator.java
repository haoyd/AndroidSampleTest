package com.sample.gofdemo.装饰模式;

/**
 * 装饰抽象类
 * Created by haoyundong on 2016/11/3.
 */

public abstract class Decorator extends Component {

    protected Component component;

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        if (component != null) {
            component.operation();
        }
    }

}
