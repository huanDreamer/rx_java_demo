package top.sillyfan.rx.demo2;


import java.util.Observable;

/**
 * 被观察者
 */
public class SimpleObservable extends Observable {

    private int data = 0;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        if (this.data != data) {
            this.data = data;

            setChanged();
            // 数据发生改变
            notifyObservers();
        }
    }
}
