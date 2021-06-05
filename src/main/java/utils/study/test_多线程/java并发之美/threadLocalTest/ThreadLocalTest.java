package utils.study.test_多线程.java并发之美.threadLocalTest;

/**
 * @Author kula
 * @create 2021/5/1 上午8:47
 */
public class ThreadLocalTest {

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    static String string;
    static void print (String str) {
        System.out.println(str + ":" + threadLocal.get());
        System.out.println(Thread.currentThread().getName() + " " + string);
        threadLocal.remove();
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            threadLocal.set("thread01 set");
            string = "thread01 string";
            print("thread01");
//            System.out.println(Thread.currentThread().getName() + " remove after " + threadLocal.get());
        });

        Thread t2 = new Thread(() -> {
            threadLocal.set("thread02 set");
            string = "thread02 string";
            print("thread02");
//            System.out.println(Thread.currentThread().getName() + " remove after " + threadLocal.get());
        });

        t1.start();
        t2.start();
    }


}
