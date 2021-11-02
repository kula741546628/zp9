package utils.study.test_多线程.volatile_test;

/**
 * @Author kula
 * @create 2021/8/3 上午12:14
 * happenedbefore 传递性原则
 */
public class T_001 {
    private static int num = 0;
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        new Thread(()->{
            while (true) {
                int c = 0;
                if (flag) {
                    c = num * 2;
                } else {
                    c = 1;
                }
                System.out.println(c);
            }
        },"线程一").start();

        new Thread(()->{
            while (true) {
                num = 2;
                flag = true;
            }
        },"线程二").start();
    }
}
