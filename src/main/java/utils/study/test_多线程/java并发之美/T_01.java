package utils.study.test_多线程.java并发之美;

/**
 * @Author kula
 * @create 2021/4/27 下午2:56
 * 一个线程含有两个对象的锁，
 */
public class T_01 {
    private static volatile Object resourseA = new Object();
    private static volatile Object resourseB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (resourseA) {
                System.out.println("线程t1获取resourseA");

                synchronized (resourseB) {
                    System.out.println("线程t1获取resourseB");
                    try {
//                        LocalDateTime time1 = LocalDateTime.now();
//                        resourseA.wait(1000*2,10000);
//                        LocalDateTime time2 = LocalDateTime.now();
//                        System.out.println("时间差："+(time2.getSecond()-time1.getSecond()));
                        resourseA.wait(0);
                        System.out.println("11111");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        resourseA.notify();
                    }
                }
            }


        });


        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000*3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (resourseA) {
                System.out.println("线程t2获取resourseA");
                try {
                    resourseB.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourseB) {
                    System.out.println("线程t2获取resourseB");
                }
            }

        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("主线程执行完毕");

    }




}
