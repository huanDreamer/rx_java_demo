package top.sillyfan.rx.demo2;

import java.util.Observable;
import java.util.Observer;

public class SimpleObserver implements Observer {

    SimpleObserver(SimpleObservable observable) {
        observable.addObserver(this);
    }

    /**
     * 被观察者状态发生改变的时候，调用该方法
     *
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("data is: " + ((SimpleObservable) o).getData());
    }
}
