package utils.study.test_多线程.thread_demo3.生产者消费者;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author kula
 * @create 2021/5/3 下午10:56
 */
public class Product implements Runnable {
    private BlockingQueue<String> blockingQueue;
    private AtomicInteger count = new AtomicInteger();
    private volatile boolean flag = true;

    public Product(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    private void stop(){
        this.flag = false;
    }


    @Override
    public void run() {
        System.out.println("生产者开始生产数据……");
        try {
            while (flag) {
                String data = count.incrementAndGet() + "";
                boolean offer = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
                if (offer) {
                    System.out.println("生产者生产数据为：" + data);
                } else {
                    System.out.println("生产者阻塞中的数据为：" + data);
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者停止运行");
        }

    }
}
