package top.sillyfan.rx.demo1;

public class WatcherTest {

    public static void main(String[] args) {
        Watched watched = new ConcreteWatched();

        Watcher w1 = new Watcher() {
            @Override
            public void update(String str) {
                System.out.println("w1 收到" + str);
            }
        };

        watched.addWatcher(w1);

        watched.notify("123");
    }
}
