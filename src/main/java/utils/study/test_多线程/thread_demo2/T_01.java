package utils.study.test_多线程.thread_demo2;

/**
 * @Author kula
 * @create 2021/4/27 下午8:51
 */
public class T_01 {


    public static void main(String[] args) {
        ThreadZp threadZp = new ThreadZp();
        ThreadZp threadZp2 = new ThreadZp();
        Thread t1 = new Thread(threadZp, "窗口1");
        Thread t2 = new Thread(threadZp2, "窗口2");
        t1.start();
        t2.start();

    }
}

class ThreadZp implements Runnable {
    private static Integer count = 10;
    public static String a = "s";
    @Override
    public void run() {

        while (count > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sale();
        }
    }


    public void sale() {
        synchronized (count) {
            if (count > 0) {
                System.out.println(Thread.currentThread().getName()+ "线程卖出第"+(10-count+1)+"张火车票");
                count--;
            }
        }

    }
}
