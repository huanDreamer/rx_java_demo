package top.sillyfan.rx.demo3;


import rx.Observable;
import rx.Subscriber;

public class RxUtils {

    private final static String TAG = RxUtils.class.getSimpleName();

    public static void main(String[] args) {
        createObservable();
    }

    public static void createObservable() {

        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                // 有订阅关系
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext("hello");
                    subscriber.onNext("next");

                    subscriber.onNext(getData());

                    subscriber.onNext("ttt");

                    subscriber.onCompleted();
                }
            }
        });

        Subscriber<String> subscriber = new Subscriber<String>() {
            // 完成
            @Override
            public void onCompleted() {
                System.out.println(TAG + " - onCompleted");
            }

            // 发生异常
            @Override
            public void onError(Throwable e) {
                System.out.println(TAG + " - onError: " + e.getMessage());
            }

            // 多次收到消息
            @Override
            public void onNext(String s) {
                System.out.println(TAG + " - onNext: " + s);
            }
        };

        // 关联订阅关系
        observable.subscribe(subscriber);
    }

    public static String getData() {
        return "this is test data";
    }
}
