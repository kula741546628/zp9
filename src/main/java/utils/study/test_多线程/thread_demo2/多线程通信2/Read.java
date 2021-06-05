package utils.study.test_多线程.thread_demo2.多线程通信2;

/**
 * @Author kula
 * @create 2021/4/30 下午7:48
 */
public class Read implements Runnable{
    private Student2 student2;

    public Read (Student2 student2) {
        this.student2 = student2;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println( Thread.currentThread().getName() + " " + student2.getName() + "   " + student2.getSex());
        }
    }
}
