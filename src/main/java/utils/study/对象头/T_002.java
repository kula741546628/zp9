package utils.study.对象头;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author kula
 * @create 2021/7/24 上午9:55
 *
 * 线程先睡眠5s，再创建对象，才会变成偏向锁
 */
public class T_002 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread.sleep(5000);
        Object lock1 = new Object();
        // 无锁
        System.out.println(ClassLayout.parseInstance(lock).toPrintable());
        // 偏向锁
        System.out.println(ClassLayout.parseInstance(lock1).toPrintable());
    }
}
