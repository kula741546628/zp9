package utils.study.test_多线程.thread_demo3.zpFuture;

/**
 * @Author kula
 * @create 2021/6/7 下午10:57
 */
public class ExtCallableImpl implements ExtCallable<Integer> {
    @Override
    public Integer call() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
