package utils.study.线程池.多线程中断;


/**
 * @Author kula
 * @create 2021/7/10 下午6:28
 */
public class Thread_01 extends Thread {
    @Override
    public void run() {
        while (this.isInterrupted()) {
//            System.out.println(1);
//
//
//            System.out.println(2);
        }
    }

    public static void main(String[] args) {
        Thread_01 thread01 = new Thread_01();
        thread01.start();
        try {
            thread01.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread01.interrupt();
    }
}
