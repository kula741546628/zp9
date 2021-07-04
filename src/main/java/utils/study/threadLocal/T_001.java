package utils.study.threadLocal;

/**
 * @Author kula
 * @create 2021/6/17 下午10:34
 */
public class T_001 {
    public static ThreadLocal threadLocal = new ThreadLocal<String>();
    public static void main(String[] args) {
        threadLocal.set("zp");
        System.gc();
        System.out.println("");
    }
}
