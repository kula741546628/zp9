package utils.study.test_多线程.thread_demo2.多线程通信;

/**
 * @Author kula
 * @create 2021/4/30 下午7:46
 */
public class Student {
    public String name;
    public String sex;
    /**
     * true为允许读，禁止写
     * false为允许写，禁止读
     */
    public boolean flag = false;
}
