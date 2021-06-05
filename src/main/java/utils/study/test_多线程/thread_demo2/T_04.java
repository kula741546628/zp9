package utils.study.test_多线程.thread_demo2;

/**
 * @Author kula
 * @create 2021/4/29 上午12:10
 */
class Res4 implements Runnable {

    private Object obj = new Object();
    private Object obj1 = new Object();
    public volatile   boolean b = true;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "子线程开始,b值为：" + b);
        if (b) {
            synchronized (obj) {
                play(b);
            }
        } else {
            System.out.println(Thread.currentThread().getName()+"线程在等待");
            try {
                Thread.sleep(1000 * 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this.getClass()) {
                System.out.println("B:" + b);
            }
        }
    }

    private synchronized void play(boolean b) {
        System.out.println("线程t1准备休眠");
//        try {
//            this.wait(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("wait等待完毕");
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("b:" + b);
    }
}
public class T_04 {
    public static void main(String[] args) throws InterruptedException {
        Res4 res4 = new Res4();
        Thread t1 = new Thread(res4);
        Thread t2 = new Thread(res4);
        t1.start();

        Thread.sleep(10);
        res4.b = false;

        System.out.println("主线程设置完b");
        t2.start();



    }
}
