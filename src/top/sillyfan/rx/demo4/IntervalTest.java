package top.sillyfan.rx.demo4;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;

import java.util.concurrent.TimeUnit;

public class IntervalTest {

    public static void main(String[] args) {

        Observable<Long> interval = Observable.interval(10, 1, TimeUnit.SECONDS);

    }
}
