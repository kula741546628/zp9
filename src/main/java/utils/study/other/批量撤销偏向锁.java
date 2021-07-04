package utils.study.other;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author kula
 * @create 2021/6/15 下午9:46
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
        }).start();

        Thread.sleep(2000);
        System.out.println("打印主线程19和20的对象锁：");
//        System.out.println(Integer.toHexString(aList.get(18).hashCode()));
        System.out.println(ClassLayout.parseInstance(aList.get(18)).toPrintable());
        System.out.println(ClassLayout.parseInstance(aList.get(19)).toPrintable());

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                Object a = aList.get(i);
                synchronized (a) {
                    if (i == 20 ||  i == 21) {
                        System.out.println("打印第二个线程的20和21的对象锁：");
                        System.out.println(ClassLayout.parseInstance(a).toPrintable());
                    }
                }
            }
        }).start();
        Thread.sleep(1000);
        System.out.println("回到主线程");
        System.out.println(ClassLayout.parseInstance(aList.get(99)).toPrintable());


    }
}
