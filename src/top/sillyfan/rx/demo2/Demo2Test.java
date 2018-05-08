package top.sillyfan.rx.demo2;

public class Demo2Test {


    public static void main(String[] args) throws InterruptedException {
        SimpleObservable simple = new SimpleObservable();

        SimpleObserver observer = new SimpleObserver(simple);

        simple.setData(123);
        simple.setData(456);

    }
}
