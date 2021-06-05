package utils.study.test_多线程.thread_demo3.生产者消费者;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author kula
 * @create 2021/5/3 下午11:06
 */
public class Consume implements Runnable{
    private BlockingQueue<String> blockingQueue;
    private boolean flag = true;
    public Consume(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("消费者开始消费数据……");
        try {
            while (flag) {
                String data = blockingQueue.poll(2, TimeUnit.SECONDS);
                if (Objects.isNull(data)) {
                    System.out.println("消费者2秒内未获取到数据！");
                    flag = false;
                    return;
                }
                System.out.println("消费者获取到数据为：" + data);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("消费者停止运行");
        }

    }
}
