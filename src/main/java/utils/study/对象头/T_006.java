package utils.study.对象头;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author kula
 * @create 2021/7/24 上午9:55
 *疑问二
 */
public class T_006 {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        Object lock = new Object();
        // 偏向锁
        System.out.println(ClassLayout.parseInstance(lock).toPrintable());
        synchronized (lock) {
            System.out.println(ClassLayout.parseInstance(lock).toPrintable());
        }
    }
}
