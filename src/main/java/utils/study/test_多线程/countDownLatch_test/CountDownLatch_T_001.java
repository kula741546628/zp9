package utils.study.test_多线程.countDownLatch_test;

import java.util.concurrent.CountDownLatch;

/**
 * @Author kula
 * @create 2021/8/11 下午12:18
 */
public class CountDownLatch_T_001 {
    public static void main(String[] args) throws InterruptedException {
//        Thread.currentThread().join();
//        api();
        /**
         * demo1
         * 场景1 让多个线程等待：模拟并发，让并发线程一起执行
         * 就像田径赛跑时，运动员会在起跑线做准备动作，等到发令枪一声响，运动员就会奋力奔跑
         * 类似时间一到，开启秒杀
         */
        demo1();
        /**
         * demo2
         * 场景2 让单个线程等待：多个线程(任务)完成后，进行汇总合并
         * 很多时候，我们的并发任务，存在前后依赖关系；比如数据详情页需要同时调用多个接口获取数据，并发请求获取到数据后、需要进行结果合并；
         */
//        demo2();



    }

    private static void demo2() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName()+"执行完成");
            }).start();
        }
        System.out.println("主线程等待其他子线程执行完毕");
        countDownLatch.await();
        System.out.println("主线程开始执行");
    }

    private static void api() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.countDown();
        // 让线程阻塞， t1调用await方法，t1线程直接阻塞，存放在aqs的双向链表中
        countDownLatch.await();
        // 初始状态值state直到减为0时，唤醒aqs类中的双向链表中的阻塞线程
        countDownLatch.countDown();
    }

    private static void demo1() {
        CountDownLatch countDownLatchTemp = new CountDownLatch(1);
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    countDownLatchTemp.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"");
            }).start();
        }
        countDownLatchTemp.countDown();
    }
}
