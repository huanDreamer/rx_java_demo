package top.sillyfan.rx.demo4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<String>(() -> "1234");

        futureTask.run();

        String s = futureTask.get();

        System.out.println(s);
    }
}
