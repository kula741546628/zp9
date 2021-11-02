package utils.study.对象头;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author kula
 * @create 2021/7/14 下午12:41
 * -XX:BiasedLockingStartupDelay=0
 *
 * javap -p -c T_001.class 查看汇编语言
 */
public class T_001 {
    private static Object lock = new Object();
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        String  A = "a";
        System.out.println(A.getClass());
        System.out.println(A.hashCode());
        System.out.println(Integer.toHexString(A.hashCode()));
        System.out.println(ClassLayout.parseInstance(A).toPrintable());


//        a();
        ZpClass zpClass = new ZpClass();
        int hashCode = zpClass.hashCode();
        System.out.println(hashCode);


        System.out.println(Integer.toHexString(hashCode));
        System.out.println(ClassLayout.parseInstance(zpClass).toPrintable());

        System.out.println(ClassLayout.parseInstance(zpClass).toPrintable());
        synchronized (zpClass) {
            System.out.println("=============");
            System.out.println(ClassLayout.parseInstance(zpClass).toPrintable());

        }
    }

    private static void a() {
        synchronized (lock) {
            count++;
        }
    }

    static class ZpClass {
        boolean b;
    }
}
