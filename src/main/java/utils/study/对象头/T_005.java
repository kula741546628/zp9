package utils.study.对象头;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author kula
 * @create 2021/7/24 上午9:55
 *  疑问一
 */
public class T_005 {
    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        Thread.sleep(5000);
        // 无锁
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        synchronized (a) {
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
        }
    }
}
