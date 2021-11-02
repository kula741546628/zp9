package utils.study.对象头;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author kula
 * @create 2021/7/24 上午9:55
 *
 * 无锁变成轻量锁，
 * 此时其他线程竞争该锁，锁就会升级重量锁
 */
public class T_003 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        System.out.println("无锁");
        System.out.println(ClassLayout.parseInstance(lock).toPrintable());
        new Thread(()->{
            synchronized (lock) {
                System.out.println("轻量锁");
                System.out.println(ClassLayout.parseInstance(lock).toPrintable());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("先睡五秒");
                System.out.println(ClassLayout.parseInstance(lock).toPrintable());
            }
        }).start();
        Thread.sleep(1000);
        synchronized (lock) {
            System.out.println("重量锁");
            System.out.println(ClassLayout.parseInstance(lock).toPrintable());
        }


    }
}
