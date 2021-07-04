package utils.study.test_多线程.thread_demo3.zpFuture;

/**
 * @Author kula
 * @create 2021/6/7 下午10:47
 */
public class Test_001 {

    public static void main(String[] args) {
        ExtCallable extCallable = new ExtCallableImpl();
        ExtFutureTask extFutureTask = new ExtFutureTask(extCallable);
        new Thread(extFutureTask).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object o = extFutureTask.get();
        System.out.println(o);
    }
}
