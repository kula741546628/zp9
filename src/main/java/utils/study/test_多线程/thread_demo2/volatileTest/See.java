package utils.study.test_多线程.thread_demo2.volatileTest;

/**
 * @Author kula
 * @create 2021/5/1 上午11:47
 */
public class See extends Thread {
    public volatile boolean b = true;

    @Override
    public void run() {
        System.out.println("线程执行开始……");
        while (b) {

        }
        System.out.println("线程执行结束……");
    }
}
