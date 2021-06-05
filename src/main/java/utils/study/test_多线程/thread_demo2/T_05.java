package utils.study.test_多线程.thread_demo2;

import java.time.LocalDateTime;

/**
 * @Author kula
 * @create 2021/4/29 下午3:31
 *
 * synchronized
 * 对象锁，相同对象互斥锁，不同对象不影响
 * 类字节码锁，所有都互斥，
 * this锁 等同于 synchronized修饰方法，同对象的线程互斥
 *
 *
 *
 *
 */
class SyncThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +" 1  "+ LocalDateTime.now());
//        synchronized (new SyncThread()) {
        synchronized (SyncThread.class) {
//        synchronized (this) {
            System.out.println(Thread.currentThread().getName() +"  2 "+ LocalDateTime.now());
            try {
                Thread.sleep(1000*2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +" 3  "+ LocalDateTime.now());
        }

//        play();
    }

    private synchronized void play() {
        System.out.println(Thread.currentThread().getName() +"  2 "+ LocalDateTime.now());
        try {
            Thread.sleep(1000*2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +" 3  "+ LocalDateTime.now());
    }
}
public class T_05 {
    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread();
        Thread t1 = new Thread(new SyncThread(), "t1");
        Thread t2 = new Thread(new SyncThread(), "t2");
        Thread t3 = new Thread(syncThread, "t3");
        Thread t4 = new Thread(syncThread, "t4");
        t1.start();
        t2.start();
//        t3.start();
//        t4.start();
    }
}
