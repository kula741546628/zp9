package utils.study.test_多线程.thread_demo2.多线程通信2;

/**
 * @Author kula
 * @create 2021/4/30 下午7:47
 */
public class T_001 {
    public static void main(String[] args) throws InterruptedException {
        Student2 student2 = new Student2();

        Read read = new Read(student2);
        Write write = new Write(student2);
        Thread t1 = new Thread(read);
        Thread t2 = new Thread(write);


        t2.start();
        Thread.sleep(1000);
        t1.start();


    }
}
