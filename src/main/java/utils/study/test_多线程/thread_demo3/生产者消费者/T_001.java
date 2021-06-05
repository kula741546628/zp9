package utils.study.test_多线程.thread_demo3.生产者消费者;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author kula
 * @create 2021/5/3 下午10:55
 */
public class T_001 {

    public static void main(String[] args) {
        LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(10);
        Product p = new Product(blockingQueue);
        Consume c = new Consume(blockingQueue);
        new Thread(p).start();
        new Thread(c).start();

    }

}
