package utils.study.test_多线程.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author kula
 * @create 2021/5/2 下午10:13
 */
public class T_001 {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        concurrentLinkedQueue.offer("1");
        concurrentLinkedQueue.offer("2");
        concurrentLinkedQueue.offer("3");
        System.out.println(concurrentLinkedQueue.size());
        System.out.println(concurrentLinkedQueue.poll());
        System.out.println(concurrentLinkedQueue.size());
        System.out.println(concurrentLinkedQueue.poll());
        System.out.println(concurrentLinkedQueue.size());
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue(3);
//        BlockingQueue blockingQueue = new ArrayBlockingQueue(4);
        arrayBlockingQueue.offer("1");
        arrayBlockingQueue.offer("1");
        arrayBlockingQueue.offer("1");
        boolean offer = arrayBlockingQueue.offer("1", 3, TimeUnit.SECONDS);
        System.out.println(offer);


    }
}
