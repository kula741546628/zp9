package utils.study.test_多线程.锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author kula
 * @create 2021/5/6 下午9:26
 * 可重入锁：ReentrantLock
 */
public class T_002 {
    public static void main(String[] args) {
        new Thread(new Thread2()).start();
    }

}

class Thread2 implements Runnable{

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        try {
            set();
        } finally {
            lock.unlock();
        }
    }
    public void set(){
        System.out.println("set 方法");
        lock.lock();
        try {
            get();
        } finally {
            lock.unlock();
        }
    }
    public void get(){
        System.out.println("get 方法");
    }
}
