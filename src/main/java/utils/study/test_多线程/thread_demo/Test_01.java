package utils.study.test_多线程.thread_demo;

/**
 * @Author kula
 * @create 2021/2/20 下午5:40
 */
public class Test_01 {

    public static void main(String[] args) {
        System.out.println("主线程开始……");
        ThreadDemo01 threadDemo01 = new ThreadDemo01();
        threadDemo01.start();
        for (int i = 0; i < 13; i++) {
            System.out.println("main线程i:" + i);
        }
        System.out.println("主线程结束……");
    }



}

class ThreadDemo01 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程i:" + i);
        }
    }
}