package utils.study.test_多线程.锁;

/**
 * @Author kula
 * @create 2021/5/6 下午9:20
 * 可重入锁：synchronized
 */
public class T_001 {

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
    }
}

class Thread1 implements Runnable{

    @Override
    public void run() {
        set();
    }

    public synchronized void set(){
        System.out.println("set方法");
        get();
    }

    public synchronized void get(){

        System.out.println("get方法");

    }

}