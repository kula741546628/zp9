package utils.study.test_多线程.thread_demo2.多线程通信;

/**
 * @Author kula
 * @create 2021/4/30 下午7:47
 */
public class T_001 {
    public static void main(String[] args) {
        Student student = new Student();

        Read read = new Read(student);
        Write write = new Write(student);
        Thread t1 = new Thread(read);
        Thread t2 = new Thread(write);
        t1.start();
        t2.start();


    }
}
