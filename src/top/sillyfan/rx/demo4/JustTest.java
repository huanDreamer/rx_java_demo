package top.sillyfan.rx.demo4;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

public class JustTest {

    public static void main(String[] args) {
        Observable.just("123", "456", "789").subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });
    }
}
