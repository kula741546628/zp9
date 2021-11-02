package utils.study.test_多线程.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author kula
 * @create 2021/5/12 下午11:12
 */
public class Aqs{
    private static Lock lock = new ReentrantLock(false);


    public static void main(String[] args) throws InterruptedException {
        Condition condition = lock.newCondition();
        lock.lock();
        condition.await();
        lock.unlock();
        Thread thread = new Thread();
        thread.wait();
    }
}
