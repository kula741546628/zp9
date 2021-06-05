package utils.study.test_多线程.zp;

/**
 * @Author kula
 * @create 2021/4/27 下午12:49
 */
public class T_02 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程："+ i);
            }
        });
        t1.setDaemon(true);
        t1.start();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(300);
                System.out.println("主线程：" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println("主线程结束");
    }
}
