package utils.study.对象头;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author kula
 * @create 2021/6/15 下午9:46
 * 补充……………………………………………………………………
 * 第一线程创建100个对象偏向给t1线程
 * 第二线程竞争这100个对象的锁时，先是升级为轻量锁，
 * 如果有很多对象的话，就不会都升级轻量锁，偏向锁就会批量偏向，
 * 由偏向锁转轻量锁超过17次后，就会批量偏向给t2线程；t2线程里后面所有对象都会偏向给t2线程
 * 如果t2线程里，偏向锁偏向次数（偏向轻量锁次数+偏向t2线程次数）不超过40次，则其他线程还会批量偏向，但是转轻量锁的次数会增加，
 * 如果t2线程里，偏向锁偏向次数（偏向轻量锁次数+偏向t2线程次数）超过40次，其他线程就不会批量偏向，则直接升级为轻量锁
 *
 */
public class 批量撤销偏向锁 {
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
            try {
                // 为了防止jvm线程复用，在创建完对象后，保持线程的状态还存活
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(2000);
        System.out.println("打印主线程17和18的对象锁：");
        System.out.println(ClassLayout.parseInstance(aList.get(16)).toPrintable());
        System.out.println(ClassLayout.parseInstance(aList.get(17)).toPrintable());

        Thread.sleep(10000);
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                Object a = aList.get(i);
                synchronized (a) {
                    System.out.println("打印第二个线程的"+i+"的对象锁：");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
//                    if (i== 16 || i == 17) {
//                        System.out.println("打印第二个线程的17和18的对象锁：");
//                        System.out.println(ClassLayout.parseInstance(a).toPrintable());
//                    }
                }
            }
            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(5000);
        new Thread(()->{
            for (int i = 0; i < 32; i++) {
                Object a = aList.get(i);
                synchronized (a) {
                    System.out.println("打印第三个线程的"+i+"的对象锁：");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                }
            }
            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(5000);
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                Object a = aList.get(i);
                synchronized (a) {
                    System.out.println("打印第四个线程的"+i+"的对象锁：");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                }
            }
            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
