package utils.study.test_多线程.thread_demo2;

/**
 * @Author kula
 * @create 2021/4/28 下午6:35
 */

class Res implements Runnable{

    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
//    private int count = 10;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            int count = threadLocal.get() + 1;
            threadLocal.set(count);
            System.out.println(Thread.currentThread().getName() + " 为：" + count);
        }
    }
}


public class T_02 {
    public static void main(String[] args) {
        Res res = new Res();
//        Res res1 = new Res();
        Thread t1 = new Thread(res);
        Thread t2 = new Thread(res);
        t1.start();
        t2.start();


    }
}
