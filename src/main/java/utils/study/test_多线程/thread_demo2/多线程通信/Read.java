package utils.study.test_多线程.thread_demo2.多线程通信;

/**
 * @Author kula
 * @create 2021/4/30 下午7:48
 */
public class Read implements Runnable{
    private  Student student;

    public Read (Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (student) {
                if (!student.flag) {
                    try {
                        student.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(student.name + "   " + student.sex);
                student.flag = false;
                student.notify();
            }

        }
    }
}
