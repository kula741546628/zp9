package utils.study.threadLocal;

import java.lang.ref.WeakReference;

/**
 * @Author kula
 * @create 2021/7/25 下午6:00
 */
public class 强软弱虚 {
    public static void main(String[] args) {
        /**
         * 1.强引用
         * GC回收内存时，不会被回收
         */
        Object o1 = new Object();// 强引用对象
        System.out.println("o1:" + o1);
        /**
         * 2.软引用
         * 申请内存不足时，才会被回收，
         */
//        Object o2 = new Object();
//        SoftReference<Object> softReference = new SoftReference<>(o2);// 软引用对象
//        o2 = null;
//        System.out.println("o2:" + o2);
//        System.out.println(softReference.get());
//        try {
//            byte[] b = new byte[30 * 1024 * 1024];
//        } catch (Exception e) {
//
//        } finally {
//            System.out.println("申请内存后");
//            System.out.println(softReference.get());
//        }
        /**
         * 3.弱引用
         * GC时就会被回收
         */
        Object o3 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o3);// 软引用对象
        o3 = null;
        System.out.println("o3:" + o3);
        System.out.println(weakReference.get());
        System.gc();
        System.out.println("GC后");
        System.out.println(weakReference.get());

    }
}
