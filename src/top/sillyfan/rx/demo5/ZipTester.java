package top.sillyfan.rx.demo5;

import org.junit.Test;
import rx.Observable;
import rx.observers.TestSubscriber;

import java.util.Arrays;
import java.util.List;

public class ZipTester {

    private List<String> words = Arrays.asList("a", "b", "c", "d", "e");

    @Test
    public void test1() {

        TestSubscriber<String> subscriber = new TestSubscriber();

        Observable<String> obs = Observable.from(words).zipWith(Observable.range(1, Integer.MAX_VALUE), (word, index) -> word + index);

        obs.subscribe(subscriber);

        subscriber.assertNotCompleted();

    }
}
