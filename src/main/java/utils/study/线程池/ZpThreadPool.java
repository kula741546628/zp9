package utils.study.线程池;

import java.util.concurrent.*;

/**
 * @Author kula
 * @create 2021/7/6 下午10:06
 */
public class ZpThreadPool {
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4,
            0, TimeUnit.SECONDS, new LinkedBlockingDeque<>(2), new ThreadPoolExecutor.DiscardPolicy());
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        };
        executorService.execute(runnable);
    }
}
