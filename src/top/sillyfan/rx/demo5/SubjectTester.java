package top.sillyfan.rx.demo5;

import org.junit.Test;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.subjects.AsyncSubject;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

import java.util.ArrayList;
import java.util.List;

public class SubjectTester {

    @Test
    public void test1() {
        AsyncSubject<String> asyncSubject = AsyncSubject.create();
        asyncSubject.onNext("asyncSubject1");
        asyncSubject.onNext("asyncSubject2");
        asyncSubject.onNext("asyncSubject3");
        asyncSubject.onCompleted();
        asyncSubject.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

                System.out.println("asyncSubject onCompleted");  //输出 asyncSubject onCompleted
            }

            @Override
            public void onError(Throwable e) {

                System.out.println("asyncSubject onError");  //不输出（异常才会输出）
            }

            @Override
            public void onNext(String s) {

                System.out.println("asyncSubject:" + s);  //输出asyncSubject:asyncSubject3
            }
        });
    }

    @Test
    public void test2() {
        BehaviorSubject<String> behaviorSubject = BehaviorSubject.create("default");
        behaviorSubject.onNext("behaviorSubject1");
        behaviorSubject.onNext("behaviorSubject2");
        behaviorSubject.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

                System.out.println("behaviorSubject:complete");
            }

            @Override
            public void onError(Throwable e) {

                System.out.println("behaviorSubject:error");
            }

            @Override
            public void onNext(String s) {

                System.out.println("behaviorSubject:" + s);
            }
        });

        behaviorSubject.onNext("behaviorSubject3");
        behaviorSubject.onNext("behaviorSubject4");

        behaviorSubject.onCompleted();

    }

    @Test
    public void test3() {
        PublishSubject<String> publishSubject = PublishSubject.create();

        publishSubject.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.print("complate");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.print(s);
            }
        });

        publishSubject.onNext("123");
        publishSubject.onCompleted();

    }

    @Test
    public void testTime() {

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            test4();
//            test5();
        }
        long end = System.currentTimeMillis();

        System.out.print(end - start);
    }

    @Test
    public void test4() {
        Observable.unsafeCreate(new Observable.OnSubscribe<List<User>>() {
            @Override
            public void call(Subscriber<? super List<User>> subscriber) {
                // 获取用户数据
                List<User> users = new ArrayList<>();
                users.add(new User("a", 10));
                users.add(new User("b", 17));
                users.add(new User("c", 7));
                users.add(new User("d", 22));
                users.add(new User("e", 32));
                users.add(new User("f", 1));
                users.add(new User("g", 18));
                subscriber.onNext(users);
            }
        })
                .flatMap(Observable::from)
                .filter(user -> user.getAge() > 10)
                .map(user -> {
                    user.setAge(user.getAge() + 10);
                    return user;
                })
                //.subscribe(System.out::println)
        ;
    }

    @Test
    public void test5() {

        List<User> users = new ArrayList<>();
        users.add(new User("a", 10));
        users.add(new User("b", 17));
        users.add(new User("c", 7));
        users.add(new User("d", 22));
        users.add(new User("e", 32));
        users.add(new User("f", 1));
        users.add(new User("g", 18));


        users.stream().filter(user -> user.getAge() > 10).peek(user -> user.setAge(user.getAge() + 10));
    }
}
