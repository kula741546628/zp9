package utils.study.test_多线程.thread_demo3.线程池;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author kula
 * @create 2021/5/4 上午10:07
 */
public class T_003 {
    public static void main(String[] args) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            newScheduledThreadPool.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ", " + finalI);
                }
            }, 3, TimeUnit.SECONDS);
        }
    }
}
