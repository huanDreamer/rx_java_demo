package top.sillyfan.rx.demo1;

import java.util.ArrayList;
import java.util.List;

public class ConcreteWatched implements Watched {

    private List<Watcher> watchers = new ArrayList<>();

    @Override
    public void addWatcher(Watcher watcher) {
        watchers.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        watchers.remove(watcher);
    }

    @Override
    public void notify(String str) {
        watchers.forEach(watcher -> watcher.update(str));
    }
}
