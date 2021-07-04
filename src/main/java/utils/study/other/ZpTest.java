package utils.study.other;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author kula
 * @create 2021/6/8 下午10:40
 */
public class ZpTest {

    private static ZpLock zpLock = new ZpLock();

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(zpLock).toPrintable());
        synchronized (zpLock) {
            System.out.println("添加synchronized后……");
            System.out.println(ClassLayout.parseInstance(zpLock).toPrintable());
        }

        synchronized (zpLock) {
            System.out.println("二次添加synchronized后……");
            System.out.println(ClassLayout.parseInstance(zpLock).toPrintable());
        }

    }




    static class ZpLock{

    }
}
