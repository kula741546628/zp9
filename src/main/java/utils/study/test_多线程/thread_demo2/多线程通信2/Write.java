package utils.study.test_多线程.thread_demo2.多线程通信2;

/**
 * @Author kula
 * @create 2021/4/30 下午7:48
 */
public class Write implements Runnable{
    private Student2 student2;

    public Write (Student2 student2) {
        this.student2 = student2;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            if (count == 0) {
                student2.setName("小红");
                student2.setSex("女");
            } else {
                student2.setName("小明");
                student2.setSex("男");
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println(student2.name.get());
            System.out.println(student2.sex.get());
            count = (count + 1)%2;
        }
    }
}
