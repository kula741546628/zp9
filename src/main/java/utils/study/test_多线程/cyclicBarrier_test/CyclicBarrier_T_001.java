package utils.study.test_多线程.cyclicBarrier_test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author kula
 * @create 2021/8/10 下午8:38
 * 同步屏障
 */
public class CyclicBarrier_T_001 {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        /**
         * 单独类中 count = 2，同步屏障后，会-1
         * count != 0时，线程阻塞，存放在Condition双向链表中
         * count = 0时，则唤醒所有线程
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        cyclicBarrier.await();
    }
}
