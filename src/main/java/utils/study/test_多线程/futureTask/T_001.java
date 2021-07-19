package utils.study.test_多线程.futureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author kula
 * @create 2021/7/11 下午4:21
 */
public class T_001 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(200000);
                return 1;
            }
        };

        FutureTask futureTask = new FutureTask(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
//        Thread.sleep(1000);
        Object o = futureTask.get();
        System.out.println(Thread.currentThread().getName());
        System.out.println(o);
    }
}
