package utils.study.对象头;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author kula
 * @create 2021/6/15 下午9:46
 * 第一线程创建100个对象偏向给t1线程
 * 第二线程竞争这100个对象的锁时，先是升级为轻量锁，
 * 如果有很多对象的话，就不会都升级轻量锁，偏向锁就会批量偏向，
 * 大约在17次后批量偏向t2线程，t2线程里后面所有对象都会偏向给t2线程
 * （前提是没有其他线程竞争的情况下）
 */
public class 批量偏向锁 {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        List<Object> aList = new ArrayList<Object>();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                Object a = new Object();
                aList.add(a);
                synchronized (a) {

                }
            }
        }).start();

        Thread.sleep(2000);
        System.out.println("打印主线程17和18的对象锁：");
//        System.out.println(Integer.toHexString(aList.get(18).hashCode()));
        System.out.println(ClassLayout.parseInstance(aList.get(16)).toPrintable());
        System.out.println(ClassLayout.parseInstance(aList.get(17)).toPrintable());

        Thread.sleep(10000);
        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                Object a = aList.get(i);
                synchronized (a) {
                    if (i==0) {
                        System.out.println("打印第二个线程的1的对象锁：");
                        System.out.println(ClassLayout.parseInstance(a).toPrintable());
                    }
                    if (i== 16 || i == 17) {
                        System.out.println("打印第二个线程的17和18的对象锁：");
                        System.out.println(ClassLayout.parseInstance(a).toPrintable());
                    }
                }
            }
        }).start();
        Thread.sleep(10000);
        System.out.println("主线程：");
        System.out.println(ClassLayout.parseInstance(aList.get(0)).toPrintable());
        System.out.println(ClassLayout.parseInstance(aList.get(49)).toPrintable());
        System.out.println(ClassLayout.parseInstance(aList.get(99)).toPrintable());

    }
}
