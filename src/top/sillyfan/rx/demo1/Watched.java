package top.sillyfan.rx.demo1;

/**
 * 被观察者
 */
public interface Watched {


    /**
     * 添加观察者
     *
     * @param watcher
     */
    void addWatcher(Watcher watcher);

    /**
     * 删除观察者
     *
     * @param watcher
     */
    void removeWatcher(Watcher watcher);

    /**
     * 通知观察者
     *
     * @param str
     */
    void notify(String str);
}
