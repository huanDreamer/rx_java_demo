package top.sillyfan.rx.demo4;

import org.junit.Test;
import rx.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableTest {

    @Test
    public void tets1() {
        Observable<String> just = Observable.just("1", "2");

        just.subscribe(System.out::print);
    }

    @Test
    public void test2() {
        Observable<String> defer = Observable.defer(() -> Observable.just("123"));

        defer.subscribe(System.out::print);
    }

    @Test
    public void test3() {
        Observable<Integer> interval = Observable.range(10, 5);

        interval.subscribe(System.out::print);

    }

    @Test
    public void test4() {
        Observable<Long> timer = Observable.timer(3, TimeUnit.SECONDS);
    }
}
