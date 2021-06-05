package utils.study.test_多线程.thread_demo2.volatileTest;

/**
 * @Author kula
 * @create 2021/5/1 上午11:40
 */
public class VolatileTest_01 {
    static volatile boolean b = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            System.out.println("线程执行开始……");
            while (b) {

            }
            System.out.println("线程执行结束……");
        }).start();
        Thread.sleep(1000);
        b = false;
    }
}
