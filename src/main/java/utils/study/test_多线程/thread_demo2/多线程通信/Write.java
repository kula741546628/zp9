package utils.study.test_多线程.thread_demo2.多线程通信;

/**
 * @Author kula
 * @create 2021/4/30 下午7:48
 */
public class Write implements Runnable{
    private Student student;

    public Write (Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (student) {
                if (student.flag) {
                    try {
                        student.wait();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (count == 0) {
                    student.name = "小红";
                    student.sex = "女";
                } else {
                    student.name = "小明";
                    student.sex = "男";
                }
                count = (count + 1)%2;

                student.flag = true;
                student.notify();
            }

        }
    }
}
