package utils.study.test_多线程.thread_demo2.volatileTest;

/**
 * @Author kula
 * @create 2021/5/1 上午11:40
 */
public class VolatileTest {
    public boolean b = true;

    public static void main(String[] args) throws InterruptedException {
        See see = new See();
        see.start();
        Thread.sleep(3000);
        see.b = false;

    }
}
