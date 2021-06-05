package utils.study.test_多线程.thread_demo3.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author kula
 * @create 2021/5/4 上午10:07
 */
public class T_004 {
    public static void main(String[] args) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            newSingleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ", " + finalI);
                }
            });
        }
    }
}
