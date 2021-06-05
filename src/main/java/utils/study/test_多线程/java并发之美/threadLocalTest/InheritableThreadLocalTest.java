package utils.study.test_多线程.java并发之美.threadLocalTest;

/**
 * @Author kula
 * @create 2021/5/1 上午9:50
 */
public class InheritableThreadLocalTest {
    static ThreadLocal<String> name = new InheritableThreadLocal<>();
    public static void main(String[] args) {
        name.set("zp");
        new Thread(()->{
            System.out.println(name.get());
        }).start();
        System.out.println(name.get());
    }
}
