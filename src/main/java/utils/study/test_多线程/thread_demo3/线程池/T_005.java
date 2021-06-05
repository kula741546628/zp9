package utils.study.test_多线程.thread_demo3.线程池;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author kula
 * @create 2021/5/5 上午10:33
 */
public class T_005 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(3));

        //任务1在核心线程中
        threadPoolExecutor.execute(new ThreadTask("任务1"));
        /**
         * 任务2，3，4在阻塞队列中
         */
        threadPoolExecutor.execute(new ThreadTask("任务2"));
        threadPoolExecutor.execute(new ThreadTask("任务3"));
        threadPoolExecutor.execute(new ThreadTask("任务4"));
        // 任务5，则创建一个新线程
        threadPoolExecutor.execute(new ThreadTask("任务5"));
        // 任务6超出线程池容量，启用拒绝策略，抛出异常
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPoolExecutor.execute(new ThreadTask("任务6"));

    }
}

class ThreadTask implements Runnable{

    private String name;

    public ThreadTask(String name){
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "：" + name);
    }
}