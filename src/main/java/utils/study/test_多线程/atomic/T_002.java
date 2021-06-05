package utils.study.test_多线程.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author kula
 * @create 2021/5/6 下午11:43
 */
public class T_002 implements Runnable{

    private AtomicInteger atomicInteger = new AtomicInteger();

    private AtomicStampedReference atomicStampedReference;


    @Override
    public void run() {
        while (true) {

            int count = getCount();

            System.out.println(Thread.currentThread().getName() + ", " +count);
            if (count >= 50) {
                break;
            }

        }

    }

    private synchronized int getCount() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return atomicInteger.incrementAndGet();
    }


    public static void main(String[] args) {
        T_002 t_001 = new T_002();
        Thread t1 = new Thread(t_001);
        Thread t2 = new Thread(t_001);
        t1.start();
        t2.start();


    }
}
