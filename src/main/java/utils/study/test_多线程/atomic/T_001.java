package utils.study.test_多线程.atomic;

/**
 * @Author kula
 * @create 2021/5/6 下午11:43
 */
public class T_001 implements Runnable{

    private int count = 0;
    @Override
    public void run() {
        while (true) {

            int count = getCount();

            System.out.println(Thread.currentThread().getName() + ", " +count);
            if (count >= 50) {
                break;
            }

        }

    }

    private int getCount() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return count++;
    }


    public static void main(String[] args) {
        T_001 t_001 = new T_001();
        Thread t1 = new Thread(t_001);
        Thread t2 = new Thread(t_001);
        t1.start();
        t2.start();


    }
}
