package utils.study.threadLocal;

/**
 * @Author kula
 * @create 2021/6/17 下午10:34
 */
public class T_001 {


    public static void main(String[] args) {
         ThreadLocal threadLocal = new ThreadLocal<String>();
         ThreadLocal threadLocal2 = new ThreadLocal<String>();
         ThreadLocal threadLocal3 = new ThreadLocal<String>();
        Thread t = Thread.currentThread();
        threadLocal.set("zp");
        threadLocal = null;
        System.gc();
//        threadLocal.remove();
        threadLocal2.set("zp2");
        threadLocal3.set("zp3");
//        System.out.println(threadLocal.get());
//        System.gc();
//        System.out.println("===============");
//        System.out.println(threadLocal.get());
    }
}
