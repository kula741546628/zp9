package utils.study.other;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author kula
 * @create 2021/7/14 下午12:41
 */
public class T_001 {
    public static void main(String[] args) {
        ZpClass zpClass = new ZpClass();
        System.out.println(ClassLayout.parseInstance(zpClass).toPrintable());

    }
    static class ZpClass {
        boolean b;
    }
}
