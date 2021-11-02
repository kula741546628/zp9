package utils.study.对象头;

import com.google.common.collect.Lists;
import org.openjdk.jol.info.ClassLayout;

import java.util.List;

/**
 * @Author kula
 * @create 2021/7/24 下午9:01
 * 偏向锁——>轻量锁
 *
 */
public class T_004 {
    public static void main(String[] args) {
        List<Object> list = Lists.newLinkedList();
        new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object lock = new Object();
            list.add(lock);
            synchronized (lock) {
                System.out.println(ClassLayout.parseInstance(lock).toPrintable());
            }
        }).start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            Object lock = list.get(0);
            System.out.println(ClassLayout.parseInstance(lock).toPrintable());
            synchronized (lock) {
                System.out.println(ClassLayout.parseInstance(lock).toPrintable());
            }
        }).start();
    }
}
