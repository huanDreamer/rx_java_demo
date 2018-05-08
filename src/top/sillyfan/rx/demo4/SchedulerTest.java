package top.sillyfan.rx.demo4;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import java.util.concurrent.FutureTask;

public class SchedulerTest {

    public static void main(String[] args) {

        FutureTask<String> futureTask = new FutureTask<String>(() -> "1234");

        Scheduler.Worker worker = Schedulers.io().createWorker();

        worker.schedule(futureTask::run);

        Observable.from(futureTask).subscribe(System.out::println);

    }
}
