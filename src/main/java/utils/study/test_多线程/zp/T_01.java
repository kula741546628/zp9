package utils.study.test_多线程.zp;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author kula
 * @create 2021/2/20 下午5:39
 */
public class T_01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new CallerTask());
        new Thread(futureTask).start();
        Object o = futureTask.get();
        System.out.println(o);

    }
}
