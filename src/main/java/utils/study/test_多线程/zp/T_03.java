package utils.study.test_多线程.zp;

/**
 * @Author kula
 * @create 2021/4/27 下午1:18
 */
public class T_03 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                    System.out.println("t1线程："+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        Thread t2 = new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                try {
                    t1.join();
                    Thread.sleep(300);
                    System.out.println("t2线程："+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                    System.out.println("t3线程："+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        t1.start();
        t2.start();
//        t3.start();

    }
}
