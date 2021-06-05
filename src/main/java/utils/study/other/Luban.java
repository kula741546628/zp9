package utils.study.other;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author kula
 * @create 2021/5/12 上午12:22
 */
public class Luban {
    static Luban luban = new Luban();
    public static void main(String[] args) {
        System.out.println(Integer.toHexString(luban.hashCode()));
        System.out.println(ClassLayout.parseInstance(luban).toPrintable());
    }
}
