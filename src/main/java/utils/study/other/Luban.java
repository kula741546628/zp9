package utils.study.other;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author kula
 * @create 2021/5/12 上午12:22
 */
public class Luban {

    private static ZpLock zpLock = new ZpLock();

    public static void main(String[] args) throws InterruptedException {
//        ZpLock zpLock = new ZpLock();
//        System.out.println(Integer.toHexString(zpLock.hashCode()));

        // 不加该参数时-XX:BiasedLockingStartupDelay=0
        System.out.println("无锁……");
        System.out.println(ClassLayout.parseInstance(zpLock).toPrintable());

        new Thread(()->{
            synchronized (zpLock) {
                System.out.println("轻量锁升级………………");
                System.out.println(ClassLayout.parseInstance(zpLock).toPrintable());
                try {
                    //
                    Thread.sleep(1000);
                    System.out.println("睡眠一秒后……");
                    System.out.println(ClassLayout.parseInstance(zpLock).toPrintable());
                    Thread.sleep(1000);
                    System.out.println("睡眠一秒后……");
                    System.out.println(ClassLayout.parseInstance(zpLock).toPrintable());
                    Thread.sleep(1000);
                    System.out.println("睡眠一秒后……");
                    System.out.println(ClassLayout.parseInstance(zpLock).toPrintable());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(1000 );
        syncA();

    }

    private static void syncA() {
        synchronized (zpLock) {
            System.out.println("重量锁升级………………");
            System.out.println(ClassLayout.parseInstance(zpLock).toPrintable());
        }
    }

    static class ZpLock{
        Integer a = 1;
    }
}
