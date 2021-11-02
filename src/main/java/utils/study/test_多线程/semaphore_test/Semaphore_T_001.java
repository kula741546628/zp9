package utils.study.test_多线程.semaphore_test;

import java.util.concurrent.Semaphore;

/**
 * @Author kula
 * @create 2021/8/10 下午7:40
 * 信号量
 */
public class Semaphore_T_001 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        semaphore.release();// 添加一个票据
        semaphore.acquire(); // 初始票据为3，3-1=2
        semaphore.acquire();// 2-1 = 1
        semaphore.acquire(); // 1-1 =0
        System.out.println("1");

        semaphore.acquire();// 没有票据则，阻塞

        System.out.println("2");




    }
}
